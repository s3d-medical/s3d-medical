package com.s3d.webapps.common.entity;

import java.io.Serializable;

public interface EntityObject extends Serializable {

	public abstract String getFdId();
	
	public abstract void setFdId(String id);
	
	public abstract void recalculateFields();	
	
	public boolean isNew();
}
