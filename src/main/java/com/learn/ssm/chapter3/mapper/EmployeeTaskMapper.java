package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

	public EmployeeTask getEmployeeTaskByEmpId(Long empId);
}
