package com.s3d.webapps.component.orientdb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.s3d.webapps.da.customer.persistence.DaCustomerProject;
import com.s3d.webapps.util.ConfigLocationsUtil;

public class OrientdbHelper {
	
	public static final String KeyFieldName = "unid";
	public static final String PictureShouyeDataForm = "picture";
	
	private final static Map<String, ODatabaseDocumentTx> dbHolder = new HashMap<String, ODatabaseDocumentTx>();
	
	/**
	 * 每个项目一个数据库，取得该项目所对应的数据库
	 * @param project
	 * @return
	 */
	public static ODatabaseDocumentTx getProjectDatabase(DaCustomerProject project){
		return getProjectDatabase(project.getFdId());
	}
	
	public static synchronized ODatabaseDocumentTx getProjectDatabase(String projectId){
		ODatabaseDocumentTx db = null;
		if(dbHolder.get(projectId)!=null) {
			db = dbHolder.get(projectId);
		}else{
			String dbpath = ConfigLocationsUtil.getWebContentPath()+ "/orientdb/"+projectId;
	        db = new ODatabaseDocumentTx ("plocal:"+dbpath);
	        if(!db.exists()){
	            db.create();
	            db.command(new OCommandSQL("CREATE CLASS "+PictureShouyeDataForm)).execute();
	        }
	        dbHolder.put(projectId, db);
		}
		if(db.isClosed()){
			db.open("admin", "admin");
		}
        return db;
	}
	
	/**
	 * 在项目的picture表中按指定id查找文档
	 * @param db
	 * @param fdId
	 * @param createDocOnNotExsit
	 * @return
	 * @throws Exception
	 */
	public static ODocument getDocumentById(ODatabaseDocumentTx db,String fdId,boolean createDocOnNotExsit) throws RuntimeException{
		OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<ODocument>("SELECT * FROM "+ PictureShouyeDataForm +" WHERE " +KeyFieldName + " = ?");
	    List<ODocument> result = db.query(query, fdId);
	    
	    if(result.size()>1){
	    	throw new RuntimeException("UNID:"+fdId+",在数据库中不唯一");
	    }
	    
	    if(result.size()==1){
	    	return result.get(0);
	    }
	    
	    if(createDocOnNotExsit){
	    	ODocument doc = new ODocument(PictureShouyeDataForm);
	    	doc.field( KeyFieldName, fdId );
            doc.save();
            return doc;
	    }
	    
		return null;
	}
}
