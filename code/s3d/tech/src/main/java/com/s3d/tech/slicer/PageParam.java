package com.s3d.tech.slicer;

/**
 * wind.chen
 */
public class PageParam {
	protected int pageNo = 1;
	protected int pageSize = 20;  // 这个值请不要修改，当需要特殊设置的时候，自己去重设此值
	
	public PageParam() {

	}

	public PageParam(Integer pageNo) {
		if(pageNo != null){
			this.pageNo = pageNo;
		}
	}

	public PageParam(Integer pageNo, Integer pageSize) {
		if(pageNo != null){
			this.pageNo = pageNo;
		}
		if(pageSize != null){
			this.pageSize = pageSize;
		}
	}
	
	public boolean isValid(){
		if(this.pageNo <= 0 || this.pageSize <=0 ){
			return false;
		}
		return true;
	}
	
	public int getStartNo() { 
		return (this.pageNo -1) * this.pageSize;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
