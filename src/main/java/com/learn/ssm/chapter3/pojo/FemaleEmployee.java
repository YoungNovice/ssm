package com.learn.ssm.chapter3.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @author xuanyang
 */
@Alias("FemaleEmployee")
public class FemaleEmployee extends Employee {

	private FemaleHealthForm femaleHealthForm = null;

	public FemaleHealthForm getFemaleHealthForm() {
		return femaleHealthForm;
	}

	public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
		this.femaleHealthForm = femaleHealthForm;
	}
	
	
}
