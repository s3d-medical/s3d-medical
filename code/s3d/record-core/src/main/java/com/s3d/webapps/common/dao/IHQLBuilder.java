package com.s3d.webapps.common.dao;

/**
 * HQL语句拼装器接口
 * 
 * @author s3d
 */
public interface IHQLBuilder {
	/**
	 * 拼装HQL语句。
	 * 
	 * @param hqlInfo
	 *            HQL信息
	 */
	public abstract HQLWrapper buildQueryHQL(HQLInfo hqlInfo);

}
