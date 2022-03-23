package com.hsbc.vo;

public class CheckRoleVO implements java.io.Serializable {


    /**
     * token
     */
    private String token;

    /**
     * 角色code
     */
    private String roleCode;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
