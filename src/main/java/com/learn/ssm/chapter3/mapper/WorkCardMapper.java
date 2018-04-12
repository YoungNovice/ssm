package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.WorkCard;

public interface WorkCardMapper {

	public WorkCard getWorkCardByEmpId(Long empId);
}
