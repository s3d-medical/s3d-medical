package com.s3d.webapps.web.vo;

import java.util.Date;

public class BaseConditionVO {
	public final static int PAGE_SHOW_COUNT = 10;

	private int pageIndex = 1;
	private int limit = 10;
	
	private String orderField;
	private String orderDirection;
	private String keywords;
	private String status;
	private Date startDate;
	private Date endDate;
		
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getLimit() {
		return limit > 0 ? limit : PAGE_SHOW_COUNT;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public int getStartIndex() {
		int pageNum = this.getPageIndex() > 0 ? this.getPageIndex() - 1 : 0;
		return pageNum * this.getLimit();
	}
}
