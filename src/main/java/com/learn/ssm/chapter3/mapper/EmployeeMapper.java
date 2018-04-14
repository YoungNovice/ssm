package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.Employee;

public interface EmployeeMapper {

	public Employee getEmployee(Long id);
	
	public Employee getEmployee2(Long id);
}
