package com.learn.ssm.chapter3.param;

import java.util.Date;

/**
 * @author xuanyang
 */
public class PdCountRoleParams {

	private String roleName;
	private int total;
	private Date execDate;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getExecDate() {
		return execDate;
	}
	public void setExecDate(Date execDate) {
		this.execDate = execDate;
	}
	
	
}
