package com.learn.ssm.chapter3.mapper;


import com.learn.ssm.chapter3.pojo.WorkCard;

/**
 * @author xuanyang
 */
public interface WorkCardMapper {

	/**
	 * 通过id 获取工牌信息
	 * @param empId 员工id
	 * @return {@link WorkCard}
	 */
	WorkCard getWorkCardByEmpId(Long empId);
}
