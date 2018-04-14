package com.learn.ssm.chapter3.mapper;

import java.util.List;
import java.util.Map;

import com.learn.ssm.chapter3.param.PageParams;
import com.learn.ssm.chapter3.param.RoleParams;
import com.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.annotations.Param;


public interface RoleMapper {
	
	public Role getRole(Long id);
	
	public List<Role> findRolesByMap(Map<String, Object> parameterMap);
	
	public List<Role> findRolesByAnnotation(@Param("roleName") String rolename, @Param("note") String note);
	
	public List<Role> findRolesByBean(RoleParams roleParam);
	
	public List<Role> findByMix(@Param("params") RoleParams roleParams, @Param("page") PageParams PageParam);
	
	public Role getRoleUseResultMap(Long id);
	
	public int insertRole(Role role);
	
	public int insertRole2(Role role);
	
	public int updateRole(Role role);
	
	public int deleteRole(Long id);
}
