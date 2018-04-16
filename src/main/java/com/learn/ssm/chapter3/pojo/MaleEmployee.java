package com.learn.ssm.chapter3.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @author xuanyang
 */
@Alias("maleEmployee")
public class MaleEmployee extends Employee {

	private MaleHealthForm maleHealthForm = null;

	public MaleHealthForm getMaleHealthForm() {
		return maleHealthForm;
	}

	public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
		this.maleHealthForm = maleHealthForm;
	}
	
	
}
