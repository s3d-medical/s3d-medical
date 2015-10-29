package com.s3d.webapps.common.dao;

import java.util.ArrayList;
import java.util.List;

public class HQLWrapper {

	public HQLWrapper() {
		super();
	}

	public HQLWrapper(String hql) {
		super();
		this.hql = hql;
	}

	public HQLWrapper(String hql, List<HQLParameter> parameterList) {
		super();
		this.hql = hql;
		this.parameterList = parameterList;
	}

	/**
	 * hql语句或片段
	 */
	public String hql = null;

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	/**
	 * hql预编译参数
	 */
	public List<HQLParameter> parameterList = new ArrayList<HQLParameter>();

	public List<HQLParameter> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<HQLParameter> parameterList) {
		this.parameterList = parameterList;
	}

	public void setParameter(HQLParameter hqlParameter) {
		parameterList.add(hqlParameter);
	}

}
