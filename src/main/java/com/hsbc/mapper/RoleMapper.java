package com.hsbc.mapper;

import com.hsbc.model.Role;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class RoleMapper {

    private static ConcurrentHashMap<String, Role> roleMap = new ConcurrentHashMap<>();

    public void save(Role role) {
        roleMap.put(role.getCode(),role);
    }

    public boolean containsRole(String code) {
        return roleMap.containsKey(code);
    }

    public void deleteByCode(String code) {
        roleMap.remove(code);
    }


    public Role getRoleByCode(String roleCode) {
        return roleMap.get(roleCode);
    }
}
