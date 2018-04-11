package com.learn.ssm.chapter3.mapper;

import com.learn.ssm.chapter3.pojo.User;

/**
 * @author Young
 */
public interface UserMapper {

	/**
	 *  getUser
	 * @param id key
	 * @return User
	 */
	User getUser(Long id);
}
