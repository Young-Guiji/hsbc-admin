package com.hsbc.mapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRoleMapper {

    private static ConcurrentHashMap<String, ArrayList<String>> userRoleMap = new ConcurrentHashMap<>();


    public void deleteRoles(String roleCode) {
        for(ArrayList list : userRoleMap.values()){
            if(list.contains(roleCode)){
                list.remove(roleCode);
            }
        }
    }

    public void deleteRolesByUsername(String usernmae) {
        userRoleMap.remove(usernmae);
    }

    public List<String> getUserRoleIds(String usernmae) {
        return userRoleMap.get(usernmae);
    }

    public void grant(String username, String roleCode) {
        ArrayList<String> userRoleIds = userRoleMap.get(username);
        if(null == userRoleIds) {
            userRoleIds = new ArrayList<>();
            userRoleMap.put(username,userRoleIds);
        }
        if(!userRoleIds.contains(roleCode)){
            userRoleIds.add(roleCode);
        }
    }
}
