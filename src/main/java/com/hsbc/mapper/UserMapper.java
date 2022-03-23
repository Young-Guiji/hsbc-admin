package com.hsbc.mapper;

import com.hsbc.model.AuthToken;
import com.hsbc.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserMapper {

    /**
     * 保存用户信息
     */
    private static ConcurrentHashMap<String,User> userData = new ConcurrentHashMap<>();

    /**
     * 用户登录 保存用户登录信息
     */
    private static ConcurrentHashMap<String,AuthToken> tokenData = new ConcurrentHashMap<>();


    public boolean containsUserName(String username) {
        return userData.containsKey(username);
    }

    public void save(User user) {
        userData.put(user.getUsername(),user);
    }

    public void deleteByUserName(String username) {
        userData.remove(username);
    }

    public User login(User user) {
        User realUser = userData.get(user.getUsername());
        String password = DigestUtils.md5Hex(user.getPassword());
        if(null != realUser && realUser.getPassword().equals(password)){
            return realUser;
        }
        return null;
    }

    public void addToken(String authToken, AuthToken token) {
        tokenData.put(authToken,token);
    }

    public AuthToken getTokenInfoByToken(String token) {
        return tokenData.get(token);
    }

    public void deleteToken(String token) {
        tokenData.remove(token);
    }

    public User getUserByUserName(String username) {
        return userData.get(username);
    }
}
