package com.s3d.webapps.common.entity;


public abstract interface TreeEntityObject extends EntityObject {
	public abstract TreeEntityObject getFdParent();

	public abstract String getFdHierarchyId();

	public abstract void setFdHierarchyId(String fdHierarchyId);
}
