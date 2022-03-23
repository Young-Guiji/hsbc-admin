package com.hsbc.service.impl;

import com.hsbc.exception.BaseBizException;
import com.hsbc.mapper.RoleMapper;
import com.hsbc.mapper.UserMapper;
import com.hsbc.mapper.UserRoleMapper;
import com.hsbc.model.AuthToken;
import com.hsbc.model.Role;
import com.hsbc.model.User;
import com.hsbc.vo.CheckRoleVO;
import com.hsbc.vo.UserRoleVO;
import com.hsbc.service.UserService;
import com.hsbc.util.id.IdUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User login(User user) {

        user = userMapper.login(user);

        return user;
    }


    @Override
    public void add(User user) {
        user.setId(IdUtil.generateId());
        if (userMapper.containsUserName(user.getUsername())) {
            throw new BaseBizException("用户已存在！");
        } else {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            userMapper.save(user);
        }
    }


    @Override
    public void delete(User user) {
        if (userMapper.containsUserName(user.getUsername())) {
            //删除用户对应角色
            userRoleMapper.deleteRolesByUsername(user.getUsername());
            //删除用户
            userMapper.deleteByUserName(user.getUsername());
        } else {
            throw new BaseBizException("用户不存在！");
        }
    }

    @Override
    public void grant(UserRoleVO userRoleVO) {
        Assert.notNull(userRoleVO.getUsername(), "用户名 不能为空");
        Assert.notNull(userRoleVO.getRoleCode(), "角色编码 不能为空");
        User user = userMapper.getUserByUserName(userRoleVO.getUsername());
        if (null == user){
            throw new BaseBizException("授权用户不存在！");
        }
        Role role = roleMapper.getRoleByCode(userRoleVO.getRoleCode());
        if (null == role){
            throw new BaseBizException("授权权限不存在！");
        }
        userRoleMapper.grant(userRoleVO.getUsername(), userRoleVO.getRoleCode());
    }

    @Override
    public List<String> getUserRoleIds(String username) {
        return userRoleMapper.getUserRoleIds(username);
    }

    @Override
    public void addToken(String authToken, AuthToken token) {
        userMapper.addToken(authToken,token);
    }

    @Override
    public void invalidate(String token) {
        AuthToken authToken = userMapper.getTokenInfoByToken(token);
        if(checkToken(token)){
            userMapper.deleteToken(token);
        }else {
            throw new BaseBizException("token已过期！");
        }

    }

    @Override
    public boolean checkRole(CheckRoleVO checkRoleVO) {
        if(!checkToken(checkRoleVO.getToken())){
            throw new BaseBizException("token已过期！");
        }
        AuthToken tokenInfo = userMapper.getTokenInfoByToken(checkRoleVO.getToken());
        List<String> userRoleIds = tokenInfo.getUserRoleCodes();
        if(userRoleIds.contains(checkRoleVO.getRoleCode())){
            return true;
        }
        return false;
    }

    @Override
    public List<Role> allRoles(String token) {
        if(!checkToken(token)){
            throw new BaseBizException("token已过期！");
        }
        AuthToken tokenInfo = userMapper.getTokenInfoByToken(token);
        List<String> userRoleIds = tokenInfo.getUserRoleCodes();
        List<Role> roleList = new ArrayList<>();
        if(null != userRoleIds){
            for(String roleCode : userRoleIds){
                roleList.add(roleMapper.getRoleByCode(roleCode));
            }
        }
        return roleList;
    }

    /**
     * 校验token是否有效
     * @return
     */
    private boolean checkToken(String token){
        AuthToken authToken = userMapper.getTokenInfoByToken(token);
        if(null == authToken || new Date().after(authToken.getExpireDate())){
           return false;
        }
        return true;
    }

}
