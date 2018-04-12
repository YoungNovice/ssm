package com.learn.ssm.chapter3.mapper;

import com.learn.ssm.chapter3.pojo.User;

/**
 * @author Young
 */
public interface UserMapper {

	/**
	 * 计算count
	 * @param firstName
	 * @return
	 */
	int countUserByFirstName(String firstName);

	/**
	 *  getUser
	 * @param id key
	 * @return User
	 */
	User getUser(Long id);
}
