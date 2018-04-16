package com.learn.ssm.chapter3.mapper;

import com.learn.ssm.chapter3.param.PageParams;
import com.learn.ssm.chapter3.param.RoleParams;
import com.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xuanyang
 */
public interface RoleMapper {

	/**
	 * 通过主键获取Role
	 * @param id 主键
	 * @return Role {@linkplain Role#toString()}
	 */
	Role getRole(Long id);

	/**
	 * 参数为map 理论上它可以传递任何参数
	 * @param parameterMap {@link Map}
	 * @return Role
	 */
	List<Role> findRolesByMap(Map<String, Object> parameterMap);

	/**
	 * 方法一般只能有一个参数 当要传递多一个参数的时候 需要用注解 {@link Param}
	 * @param rolename String roleName
	 * @param note String note
	 * @return List Role
	 */
	List<Role> findRolesByAnnotation(@Param("roleName") String rolename, @Param("note") String note);

	/**
	 * 参数为Bean
	 * @param roleParam roleparam
	 * @return List
	 */
	List<Role> findRolesByBean(RoleParams roleParam);

	/**
	 * 多个参数用注解
	 * @param roleParams condition1
	 * @param pageParams condition2
	 * @return List
	 */
	List<Role> findByMix(@Param("params") RoleParams roleParams, @Param("page") PageParams pageParams);

	/**
	 * key=id
	 * @param id long
	 * @return Role
	 */
	Role getRoleUseResultMap(Long id);

	/**
	 * 新增
	 * @param role role
	 * @return rownum
	 */
	int insertRole(Role role);

	/**
	 * 新增2
	 * @param role role
	 * @return rownum
	 */
	int insertRole2(Role role);

	/**
	 * 更新 Role
	 * @param role role
	 * @return rownum
	 */
	int updateRole(Role role);

	/**
	 * 删除
	 * @param id id
	 * @return rownum
	 */
	int deleteRole(Long id);
}
