package com.s3d.webapps.da.customer.persistence;

import java.sql.Blob;
import java.util.Date;

import net.sf.cglib.transform.impl.InterceptFieldEnabled;

import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.da.config.persistence.DaConfigCategory;

/**
 * 图片缩引
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaCustomerPicture extends BaseEntityObject implements InterceptFieldEnabled {

	/**
	 * 图片文件名
	 */
	protected String fdPicName;
	
	/**
	 * @return 图片文件名
	 */
	public String getFdPicName() {
		return fdPicName;
	}
	
	/**
	 * @param fdPicName 图片文件名
	 */
	public void setFdPicName(String fdPicName) {
		this.fdPicName = fdPicName;
	}
	
	/**
	 * 原图光点号
	 */
	protected Integer fdOrder;
	
	
	public Integer getFdOrder() {
		return fdOrder;
	}

	public void setFdOrder(Integer fdOrder) {
		this.fdOrder = fdOrder;
	}

	/**
	 * 图片路径
	 */
	protected String fdPicPath;
	
	/**
	 * @return 图片路径
	 */
	public String getFdPicPath() {
		return fdPicPath;
	}
	
	/**
	 * @param fdPicPath 图片路径
	 */
	public void setFdPicPath(String fdPicPath) {
		this.fdPicPath = fdPicPath;
	}
	
	/**
	 * 图片类型
	 */
	protected String fdPicType;
	
	/**
	 * @return 图片类型
	 */
	public String getFdPicType() {
		return fdPicType;
	}
	
	/**
	 * @param fdPicType 图片类型
	 */
	public void setFdPicType(String fdPicType) {
		this.fdPicType = fdPicType;
	}
	
	/**
	 * 扫描时间
	 */
	protected Date fdCreateTime;
	
	/**
	 * @return 扫描时间
	 */
	public Date getFdCreateTime() {
		return fdCreateTime;
	}
	
	/**
	 * @param fdCreateTime 扫描时间
	 */
	public void setFdCreateTime(Date fdCreateTime) {
		this.fdCreateTime = fdCreateTime;
	}
	
	/**
	 * 更新时间
	 */
	protected Date fdLastModifiedTime;
	
	/**
	 * @return 更新时间
	 */
	public Date getFdLastModifiedTime() {
		return fdLastModifiedTime;
	}
	
	/**
	 * @param fdLastModifiedTime 更新时间
	 */
	public void setFdLastModifiedTime(Date fdLastModifiedTime) {
		this.fdLastModifiedTime = fdLastModifiedTime;
	}
	
	/**
	 * 图片MD5值
	 */
	protected String fdMd5Hash;
	
	/**
	 * @return 图片MD5值
	 */
	public String getFdMd5Hash() {
		return fdMd5Hash;
	}
	
	/**
	 * @param fdMd5Hash 图片MD5值
	 */
	public void setFdMd5Hash(String fdMd5Hash) {
		this.fdMd5Hash = fdMd5Hash;
	}
	
	/**
	 * 缩影
	 */
	protected Blob fdThumb;
	
	/**
	 * @return 缩影
	 */
	public Blob getFdThumb() {
		return (Blob) readLazyField("fdThumb", fdThumb);
	}
	
	/**
	 * @param fdThumb 缩影
	 */
	public void setFdThumb(Blob fdThumb) {
		this.fdThumb = (Blob) writeLazyField("fdThumb",
				this.fdThumb, fdThumb);
	}

	/**
	 * 病案号
	 */
	protected String fdFileNo;
	
	/**
	 * @return 病案号
	 */
	public String getFdFileNo() {
		return fdFileNo;
	}
	
	/**
	 * @param fdFileNo 病案号
	 */
	public void setFdFileNo(String fdFileNo) {
		this.fdFileNo = fdFileNo;
	}
	
	/**
	 * 盘号
	 */
	protected DaCustomerLabel fdLabel;
	
	/**
	 * @return 盘号
	 */
	public DaCustomerLabel getFdLabel() {
		return fdLabel;
	}
	
	/**
	 * @param fdLabel 盘号
	 */
	public void setFdLabel(DaCustomerLabel fdLabel) {
		this.fdLabel = fdLabel;
	}
	
	/**
	 * 病案分类
	 */
	protected DaConfigCategory fdCategory;
	
	/**
	 * @return 病案分类
	 */
	public DaConfigCategory getFdCategory() {
		return fdCategory;
	}
	
	/**
	 * @param fdCategory 病案分类
	 */
	public void setFdCategory(DaConfigCategory fdCategory) {
		this.fdCategory = fdCategory;
	}
}
