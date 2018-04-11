package com.common.base.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息
 * @author Young
 */
public class PageInfo<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 自动统计总量
	 */
	private boolean autoCount;
	/**
	 * 页码
	 */
	private int pageNumber;
	/**
	 * 页大小
	 */
	private int pageSize;
	/**
	 * 数据总量
	 */
	private int totalRow = -1;
	/**
	 * 页数
	 */
	private int totalPage;
	/**
	 * 数据
	 */
	private List<T> list;
	/**
	 * 排序字段
	 */
	private String orderField;
	/**
	 * 排序方式
	 */
	private String orderWay;
	
	public PageInfo() {
	}

	public PageInfo(List<T> list, int pageSize, int recordCount, int pageIndex) {
		this.list = list;
		this.pageSize = pageSize;
		setTotalRow(recordCount);
		this.pageNumber = pageIndex;
		
	}
	public boolean isAutoCount() {
		return autoCount;
	}
	public void setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		if(pageSize>0){
			setTotalPage(totalRow/pageSize+(totalRow%pageSize>0?1:0));
            if(getPageNumber()>getTotalPage()){
            	setPageNumber(getTotalPage());
            }
		}
		this.totalRow = totalRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderWay() {
		return orderWay;
	}
	public void setOrderWay(String orderWay) {
		this.orderWay = orderWay;
	}
	
	/**
	 * @return 分页开始行号
	 */
	public int getStartIndex(){
		return (getPageNumber()-1)*getPageSize();
	}
	/**
	 * @return 分页结束行号
	 */
	public int getEndIndex(){
		return getPageNumber()*getPageSize();
	}

	public int getPageIndex() {
		return pageNumber;
	}
	public void setPageIndex(int pageIndex) {
		this.pageNumber = pageIndex;
	}
	public int getRecordCount() {
		return totalRow;
	}
	public void setRecordCount(int recordCount) {
		this.totalRow = recordCount;
	}

}
