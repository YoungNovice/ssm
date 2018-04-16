package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.EmployeeTask;

/**
 * @author xuanyang
 */
public interface EmployeeTaskMapper {

	/**
	 * 通过员工id 获取员工任务信息
	 * @param empId 员工id
	 * @return EmployeeTask
	 */
	EmployeeTask getEmployeeTaskByEmpId(Long empId);
}
