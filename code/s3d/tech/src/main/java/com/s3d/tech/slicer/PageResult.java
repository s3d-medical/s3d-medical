package com.s3d.tech.slicer;

import java.util.ArrayList;
import java.util.List;


/**
 * 查询接口封装类
 * @author wind.chen
 */
public class PageResult<T> {
	private static final long serialVersionUID = 626205010898309857L;
	
	private Long totalRecords = 0L;
	private int pageNo;
	private int pageSize;
	private List<T> results = new ArrayList<T>();

    private Long counter;

    public PageResult() {
    }

    public PageResult(Long totalRecords, List<T> objects, PageParam queryPageParam){
        this.init(totalRecords, objects, queryPageParam.getPageSize(), queryPageParam.getPageNo());
    }
    public PageResult(Long totalRecords, List<T> objects, int pageSize, int pageNo){
        this.init(totalRecords, objects, pageSize, pageNo);
	}

    /**
     *
     * @param totalRecords
     * @param objects
     * @param pageSize
     * @param pageNo
     */
    public void init(Long totalRecords, List<T> objects, int pageSize, int pageNo){
        if(totalRecords != null){
            this.totalRecords = totalRecords;
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        if(pageSize <0){
            this.pageSize = 20;
        }
        if(objects != null && objects.size() > 0){
            this.results.addAll(objects);
        }
    }
	public Long getTotalRecords() {
		if(totalRecords == null) {
			return 0L;
		}
		return totalRecords;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return the results
	 */
	public List<T> getResults() {
		return results;
	}

	public long getTotalPages() {
		if(getTotalRecords() <= 0) {
			return 0;
		}

		if(pageSize <= 0){
			pageSize = 20;
		}

		if(totalRecords % pageSize == 0) {
			return totalRecords / pageSize;
		}
		return totalRecords / pageSize + 1;
	}
}
