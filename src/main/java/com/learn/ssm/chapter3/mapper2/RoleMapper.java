package com.learn.ssm.chapter3.mapper2;
import com.learn.ssm.chapter3.pojo2.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
/**
 * @author Young
 */
public interface RoleMapper {


	/**
	 * rowBounds 在sql 中不用声明
	 * @param roleName
	 * @param note
	 * @param rowBounds
	 * @return
	 */
	List<Role> findByRowBounds(@Param("roleName") String roleName,
							   @Param("note") String note,
							   RowBounds rowBounds);

	/**
	 * 借助注解传递多参数 传递多参数的时候paramType 不需要写
	 * @param roleName roleName
	 * @param note note
	 * @return List
	 */
	List<Role> findRolesByAnnotation(@Param("roleName") String roleName,
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