package com.learn.ssm.chapter3.mapper;
import com.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Young
 */
public interface RoleMapper {


	/**
	 * 借助注解传递多参数 传递多参数的时候paramType 不需要写
	 * @param roleName roleName
	 * @param note note
	 * @return List
	 */
	public List<Role> findRolesByAnnotation(@Param("roleName") String roleName,
											@Param("note") String note);

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