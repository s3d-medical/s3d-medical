package com.s3d.webapps.da.customer.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.da.config.DASysProperties;
import com.s3d.webapps.da.customer.constant.Constants;
import com.s3d.webapps.da.customer.persistence.DaCustomerLabel;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.da.customer.service.IDaCustomerLabelService;
import com.s3d.webapps.da.customer.service.IDaCustomerPictureService;
import com.s3d.webapps.util.IDGenerator;
import com.s3d.webapps.util.MD5Util;


/**
 * 后台读取盘号图片，获取文件数和光点数，并生成缩略图
 * @author ThinkPad User
 *
 */
@Service
public class LabelScanServiceImp implements Runnable{
	
	private boolean run;
	
	@PreDestroy
	public void destroy() {
		this.run = false;
	}
	
	
	@PostConstruct
	public void init() {
		Thread thread = new Thread(this);
		this.run = true;
		thread.setDaemon(true);
		thread.setName("scan-label-files");
		thread.start();
	}
	
	private final LinkedList<String> labelList = new LinkedList<String>();
	
	private final long SLEEP_TIME = 30 * 60 * 1000;

	private final int MAX_COUNT = 1;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition working = lock.newCondition();
	
	@Override
	public void run() {
		while (this.run){
			try {
				try {
					lock.lock();
					try {
						working.await(SLEEP_TIME, TimeUnit.MILLISECONDS);
					} finally {
						lock.unlock();
					}
				} catch (InterruptedException e) {

				}
				
				Session session = null;
				Transaction tx = null;
				
				try {
					if (labelList.isEmpty()) {
						continue;
					}
					session = daCustomerLabelService.getBaseDao().getHibernateSession();
					tx = session.beginTransaction();
					
					String labelId;
					while (true) {
						lock.lock();
						try {
							labelId = labelList.poll();
						} finally {
							lock.unlock();
						}
						if (labelId == null)
							break;
						
						DaCustomerLabel label = (DaCustomerLabel) daCustomerLabelService.findByPrimaryKey(labelId, null, true);
						if(label!=null) {
							label.setFdAlterTime(new Date());
							label.setFdStatus(Constants.DaCustomerLabel_Status_InProcess);
							session.update(label);
							
							session.flush();
							session.clear();
							
							String name = label.getFdName();
							String path = DASysProperties.getDataFilePath()+"/"+name;
							
							File file = new File(path);
							List<File> fileList = listDirectory(file);
							List<String> nameList = new ArrayList<String>();
							
							for (File file2 : fileList) {
								boolean checkIsImage = true;
								try {
									BufferedImage image = ImageIO.read(file2);
									if(image == null)  checkIsImage = false;
								} catch (IOException e) {
									checkIsImage = false;
								}
								if(checkIsImage){
									nameList.add(file2.getName());
									String hash = MD5Util.getMD5String(file2);
									DaCustomerPicture picture = daCustomerPictureService.getPictureByMd5Hash(hash);
									if(picture==null){
										picture = new DaCustomerPicture();
										picture.setFdId(IDGenerator.generateID());
										picture.setFdCreateTime(new Date());
										picture.setFdLabel(label);
										picture.setFdMd5Hash(hash);
										String filename = file2.getName().substring(0,file2.getName().indexOf('.'));
										picture.setFdPicName(filename);
										try{
											picture.setFdOrder(Integer.valueOf(filename));	
										}catch(Exception e){}
										picture.setFdPicPath(file2.getAbsolutePath());
										//picture.setFdPicType("");
										
										ByteArrayOutputStream out = new ByteArrayOutputStream();
										Thumbnails.of(file2).size(330,440)
									        .outputQuality(0.8f).outputFormat("jpg").toOutputStream(out);
										InputStream in = new ByteArrayInputStream(out.toByteArray());
										picture.setFdThumb(Hibernate.createBlob(in));
										out.close();
										in.close();
										
										picture.setFdLastModifiedTime(new Date());
										session.save(picture);
									}
								}
							}
							
							if(! nameList.isEmpty()){
								label.setFdFileCount(nameList.size());
								Collections.sort(nameList);
								label.setFdFrom(nameList.get(0));
								label.setFdTo(nameList.get(nameList.size()-1));
								label.setFdAlterTime(new Date());
								label.setFdStatus(Constants.DaCustomerLabel_Status_Processed);
								session.update(label);
								session.flush();
								session.clear();
							}
						}
					}
					tx.commit();
					tx = null;
					session.close();
					session = null;
				} catch (Throwable e) {
					e.printStackTrace();
					if (tx != null) {
						try {
							tx.rollback();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					if (session != null) {
						try {
							session.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
				if (labelList.size() > MAX_COUNT * 2) {
					lock.lock();
					try {
						labelList.clear();
					} finally {
						lock.unlock();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 添加盘号进入扫描队列
	 * 
	 * @param label
	 */
	public void scan(String labelId) {
		lock.lock();
		try {
			if(labelId==null) return;
			labelList.add(labelId);
			if (labelList.size() >= MAX_COUNT) {
				working.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}
	
	
	private List<File> listDirectory(File dir) {
		List<File> fileList = new ArrayList<File>();
		if (dir != null && dir.exists()) {
			if (dir.isDirectory()) {
				File[] files;
				try {
					files = dir.listFiles();
				} catch (SecurityException e) {
					files = null;
					e.printStackTrace();
				}

				if (files == null) {
					return fileList;
				} else {
					for (int i = 0; i < files.length; i++) {
						if (files[i].isDirectory()) {
							fileList.addAll(listDirectory(files[i]));
						} else {
							fileList.add(files[i]);
						}
					}
				}
			}
		}
		return fileList;
	}
	
	@Autowired
	private IDaCustomerLabelService daCustomerLabelService;
	
	@Autowired
	private IDaCustomerPictureService daCustomerPictureService;
	
}
