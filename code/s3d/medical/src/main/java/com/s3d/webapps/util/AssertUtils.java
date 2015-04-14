package com.s3d.webapps.util;

import com.s3d.webapps.common.entity.EntityObject;

public class AssertUtils {
	
	/**
	 * Assert为非新业务对象
	 * @param entityObject
	 */
	public static void notNewEntityObject(EntityObject entityObject){
		if (entityObject.isNew()){
			throw new java.lang.IllegalArgumentException();
		}
	}
	
	/**
	 * Assert为新业务对象
	 * @param entityObject
	 */
	public static void newEntityObject(EntityObject entityObject){
		if (!entityObject.isNew()){
			throw new java.lang.IllegalArgumentException();
		}
	}
	
}
