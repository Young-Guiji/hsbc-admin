package com.hsbc.service.impl;

import com.hsbc.exception.BaseBizException;
import com.hsbc.mapper.RoleMapper;
import com.hsbc.mapper.UserRoleMapper;
import com.hsbc.model.Role;
import com.hsbc.service.RoleService;
import com.hsbc.util.id.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void add(Role role) {
        if(roleMapper.containsRole(role.getCode())){
            throw new BaseBizException("角色已存在！");
        }
        role.setId(IdUtil.generateId());
        roleMapper.save(role);
    }


    @Override
    public void delete(Role role) {
        if(roleMapper.containsRole(role.getCode())){
            // 删除角色
            roleMapper.deleteByCode(role.getCode());
            // 删除角色对应关系
            userRoleMapper.deleteRoles(role.getCode());
        }else {
            throw new BaseBizException("角色不存在！");
        }
    }

}
