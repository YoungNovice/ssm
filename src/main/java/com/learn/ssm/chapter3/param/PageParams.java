package com.learn.ssm.chapter3.param;

/**
 * @author xuanyang
 */
public class PageParams {
	private int start;
	private int limit;

	private Integer page;
	private Integer pageSzie;
	private Boolean useFlag;

	private Boolean checkFlag;
	private Boolean cheanOrderBy;
	private Integer total;





	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
