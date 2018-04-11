package com.learn.ssm.chapter3.mapper;
import com.learn.ssm.chapter3.pojo.Role;

import java.util.List;
/**
 * @author Young
 */
public interface RoleMapper {

	/**
	 * insertRole
	 * @param role role
	 * @return int
	 */
	public int insertRole(Role role);

	/**
	 * deleteRole
	 * @param id key
	 * @return int
	 */
	public int deleteRole(Long id);

	/**
	 * updateRole
	 * @param role role
	 * @return int
	 */
	public int updateRole(Role role);

	/**
	 * getRole
	 * @param id key
	 * @return Role
	 */
	public Role getRole(Long id);

	/**
	 * findRoles
	 * @param roleName String
	 * @return List
	 */
	public List<Role> findRoles(String roleName);
}