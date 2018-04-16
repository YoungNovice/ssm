package com.learn.ssm.chapter3.mapper;

import com.learn.ssm.chapter3.pojo.Task;

/**
 * @author xuanyang
 */
public interface TaskMapper {

	/**
	 * 通过id 获取任务信息
	 * @param id long
	 * @return Task
	 */
	Task getTask(Long id);
}
