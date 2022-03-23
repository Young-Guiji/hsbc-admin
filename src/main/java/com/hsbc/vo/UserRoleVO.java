package com.hsbc.vo;

/**
 *
 * @author Xieboyun
 */
public class UserRoleVO implements java.io.Serializable{

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色code
     */
    private String roleCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
