package com.learn.ssm.chapter3.mapper;

import com.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.annotations.Select;


/**
 * map sql by anntation
 *
 * @author Young
 */
public interface RoleMapper2 {

	/**
	 * getRole
	 * @param id key
	 * @return Role
	 */
	@Select("select id, role_name as roleName, note from t_role where id=#{id}")
	Role getRole(Long id);
}
