package com.hsbc.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Xieboyun
 */
public class AuthToken implements java.io.Serializable {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * token过期时间
     */
    private Date expireDate;
    /**
     * 用户角色
     */
    private List<String> userRoleCodes;

    public AuthToken(Long id, String username, Date expireDate, List<String> userRoleCodes) {
        this.id = id;
        this.username = username;
        this.expireDate = expireDate;
        this.userRoleCodes = userRoleCodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public List<String> getUserRoleCodes() {
        return userRoleCodes;
    }

    public void setUserRoleCodes(List<String> userRoleCodes) {
        this.userRoleCodes = userRoleCodes;
    }
}
