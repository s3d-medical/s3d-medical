package com.s3d.webapps.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.Type;

import com.s3d.webapps.util.ModelUtil;

/**
 * HQL语句的信息描述。<br>
 * 
 * @author s3d
 * @version 1.0 2006-04-02
 */
public class HQLInfo implements Cloneable {
	/**
	 * 系统自己判断是否需要过滤
	 */
	public final static int DISTINCT_AUTO = 2;

	/**
	 * 不过滤重复值
	 */
	public final static int DISTINCT_NO = 0;

	/**
	 * 过滤重复值
	 */
	public final static int DISTINCT_YES = 1;

	private String authCheckType = null;

	private boolean autoFetch = true;

	private int distinctType = DISTINCT_AUTO;

	private String fromBlock = null;

	private boolean getCount = true;

	private boolean gettingCount = false;

	private String joinBlock = null;

	private String modelName = null;

	private String modelTable = null;

	private String orderBy = null;

	private int pageNo = 1;

	private List<HQLParameter> parameterList = new ArrayList<HQLParameter>();

	private int rowSize = 12;

	private String selectBlock = null;

	private String whereBlock = null;

	public Object clone() throws CloneNotSupportedException {
		HQLInfo hqlInfo = (HQLInfo) super.clone();
		hqlInfo.parameterList = new ArrayList<HQLParameter>(parameterList);
		return hqlInfo;
	}

	public String getAuthCheckType() {
		return authCheckType;
	}

	public int getDistinctType() {
		return distinctType;
	}

	public String getFromBlock() {
		return fromBlock;
	}

	public String getJoinBlock() {
		return joinBlock;
	}

	public String getModelName() {
		return modelName;
	}

	public String getModelTable() {
		if (modelTable == null)
			modelTable = ModelUtil.getModelTableName(modelName);
		return modelTable;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public int getPageNo() {
		return pageNo;
	}

	public List<HQLParameter> getParameterList() {
		return parameterList;
	}

	public int getRowSize() {
		return rowSize;
	}

	public String getSelectBlock() {
		return selectBlock;
	}

	public String getWhereBlock() {
		return whereBlock;
	}

	public boolean isAutoFetch() {
		return autoFetch;
	}

	public boolean isGetCount() {
		return getCount;
	}

	protected boolean isGettingCount() {
		return gettingCount;
	}

	/**
	 * 设置查询时需要过滤什么样的权限，取值见常量表SysAuthConstant
	 * 
	 * @param authCheckType
	 */
	public void setAuthCheckType(String authCheckType) {
		this.authCheckType = authCheckType;
	}

	/**
	 * 设置查询时自动过滤重复数据的类型
	 * 
	 * @param distinctType
	 */
	public void setDistinctType(int distinctType) {
		this.distinctType = distinctType;
	}

	/**
	 * 设置from语句
	 * 
	 * @param fromBlock
	 */
	public void setFromBlock(String fromBlock) {
		this.fromBlock = fromBlock;
	}

	public void setGetCount(boolean getCount) {
		this.getCount = getCount;
	}

	protected void setGettingCount(boolean gettingCount) {
		this.gettingCount = gettingCount;
	}

	/**
	 * 设置是否自动展开相关的字段信息
	 * 
	 * @param autoFetch
	 */
	public void setIsAutoFetch(boolean autoFetch) {
		this.autoFetch = autoFetch;
	}

	/**
	 * 设置紧跟在from语句后面的join语句
	 * 
	 * @param joinBlock
	 */
	public void setJoinBlock(String joinBlock) {
		this.joinBlock = joinBlock;
	}

	/**
	 * 设置域模型名称
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
		this.modelTable = null;
	}

	/**
	 * 设置排序字段
	 * 
	 * @param orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * 设置从第几页开始显示
	 * 
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setParameter(String key, Object value) {
		parameterList.add(new HQLParameter(key, value));
	}

	public void setParameter(String key, Object value, Type type) {
		parameterList.add(new HQLParameter(key, value, type));
	}

	public void setParameter(List<HQLParameter> parameterList) {
		this.parameterList.addAll(parameterList);
	}

	/**
	 * 设置每页显示多少条记录
	 * 
	 * @param rowSize
	 */
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	/**
	 * 设置select语句，不设置则返回域模型
	 * 
	 * @param selectBlock
	 */
	public void setSelectBlock(String selectBlock) {
		this.selectBlock = selectBlock;
	}

	/**
	 * 设置where语句
	 * 
	 * @param whereBlock
	 */
	public void setWhereBlock(String whereBlock) {
		this.whereBlock = whereBlock;
	}
}
