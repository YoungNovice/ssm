package com.learn.ssm.chapter3.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @author xuanyang
 */
@Alias("femaleHealthForm")
public class FemaleHealthForm extends HealthForm {

	private String uterus;

	public String getUterus() {
		return uterus;
	}

	public void setUterus(String uterus) {
		this.uterus = uterus;
	}
	
}
