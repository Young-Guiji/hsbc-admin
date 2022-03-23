package com.hsbc.service;

import com.hsbc.model.Role;

/**
 * 角色业务逻辑
 * 
 * @author Xieboyun
 * 
 */
public interface RoleService {

	/**
	 * 保存角色
	 * 
	 * @param role
	 */
	void add(Role role);


	/**
	 * 删除角色
	 * 
	 * @param role
	 */
	void delete(Role role);
}
