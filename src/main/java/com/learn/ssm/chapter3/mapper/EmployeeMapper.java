package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.Employee;

/**
 * @author xuanyang
 */
public interface EmployeeMapper {

	/**
	 * 通过id 获取员工
	 * @param id Long
	 * @return Employee
	 */
	Employee getEmployee(Long id);

	/**
	 * 通过id 获取员工
	 * @param id Long
	 * @return Employee
	 */
	Employee getEmployee2(Long id);
}
