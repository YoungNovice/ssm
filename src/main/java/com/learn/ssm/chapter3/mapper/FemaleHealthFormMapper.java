package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.FemaleHealthForm;

/**
 * @author xuanyang
 */
public interface FemaleHealthFormMapper {

	/**
	 * 通过员工id 获取女性健康表
	 * @param empId 员工id
	 * @return FemaleHealthForm
	 */
	FemaleHealthForm getFemaleHealthForm(Long empId);
}
