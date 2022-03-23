package com.hsbc.service;


import com.hsbc.model.AuthToken;
import com.hsbc.model.Role;
import com.hsbc.model.User;
import com.hsbc.vo.CheckRoleVO;
import com.hsbc.vo.UserRoleVO;

import java.util.List;

/**
 * 用户Service
 *
 * @author Xieboyun
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param user 里面包含登录名和密码
     * @return 用户对象
     */
    User login(User user);


    /**
     * 添加用户
     *
     * @param user
     */
    void add(User user);

    /**
     * 删除用户
     *
     * @param user
     */
    void delete(User user);

    /**
     * 用户授权
     *
     * @param userRoleVO
     */
    void grant(UserRoleVO userRoleVO);

    /**
     * 获取用户角色列表
     * @param username
     * @return
     */
    List<String> getUserRoleIds(String username);

    /**
     * 添加token信息
     * @param authToken
     * @param token
     */
    void addToken(String authToken, AuthToken token);

    /**
     * 注销
     * @param token
     */
    void invalidate(String token);

    /**
     * 校验角色
     * @param checkRoleVO
     * @return
     */
    boolean checkRole(CheckRoleVO checkRoleVO);

    /**
     * 获取所有角色
     * @param token
     * @return
     */
    List<Role> allRoles(String token);
}
