package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.param.PdCountRoleParams;
import com.learn.ssm.chapter3.param.PdFindRoleParams;

/**
 * @author xuanyang
 */
public interface PdRoleMapper {

	/**
	 * 计算角色的数量
	 * @param pdCountRoleParams {@link PdCountRoleParams#total}
	 */
	void countRole(PdCountRoleParams pdCountRoleParams);

	/**
	 * 获取角色信息
	 * @param pdFindRoleParams {@linkplain PdFindRoleParams#roleList roleList}
	 */
	void findRole(PdFindRoleParams pdFindRoleParams);
}
