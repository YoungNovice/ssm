package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.MaleHealthForm;

/**
 * @author xuanyang
 */
public interface MaleHealthFormMapper {

	/**
	 * 通过员工id 获取女性健康表
	 * @param empId 员工id
	 * @return MaleHealthForm
	 */
	MaleHealthForm getMaleHealthForm(Long empId);
}
