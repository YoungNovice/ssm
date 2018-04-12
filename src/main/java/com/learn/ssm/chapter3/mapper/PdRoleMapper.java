package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.param.PdCountRoleParams;
import com.learn.ssm.chapter3.param.PdFindRoleParams;

public interface PdRoleMapper {

	public void countRole(PdCountRoleParams pdCountRoleParams);
	
	public void findRole(PdFindRoleParams pdFindRoleParams);
}
