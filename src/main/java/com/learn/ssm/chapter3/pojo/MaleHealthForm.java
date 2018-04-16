package com.learn.ssm.chapter3.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @author xuanyang
 */
@Alias("maleHealthForm")
public class MaleHealthForm extends HealthForm {
	
	private String prostate;

	public String getProstate() {
		return prostate;
	}

	public void setProstate(String prostate) {
		this.prostate = prostate;
	}
	
}
