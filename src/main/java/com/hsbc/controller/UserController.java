package com.hsbc.controller;

import com.hsbc.exception.BaseBizException;
import com.hsbc.model.*;
import com.hsbc.service.UserService;
import com.hsbc.util.JsonUtil;
import com.hsbc.vo.CheckRoleVO;
import com.hsbc.vo.UserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    public static Calendar calendar = Calendar.getInstance();

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param u 用户对象
     * @return
     */
    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestResp login(@RequestBody User u) {

        User user = userService.login(u);
        String authToken = "";

        if (user != null) {
            authToken = createToken(user);
        } else {
            throw new BaseBizException("用户名或密码错误");
        }
        return RestResp.ok(authToken);
    }

    private String createToken(User user) {
        Long id = user.getId();
        String username = user.getUsername();
        Date date = buildExpirationDate();
        List<String> userRoleCodes = userService.getUserRoleIds(username);

        String authToken = id + " " +username;

        AuthToken token = new AuthToken(id,username,date,userRoleCodes);
        // 保存token信息
        userService.addToken(authToken,token);


        return authToken;
    }

    private Date buildExpirationDate() {
        calendar.add(Calendar.HOUR, 2);
        return calendar.getTime();
    }


    /**
     * 添加用户
     *
     * @return
     */
    @ApiOperation("添加用户")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestResp add(@RequestBody User user) {
        userService.add(user);
        return RestResp.ok("添加成功");
    }

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @ApiOperation("删除用户")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResp delete(@RequestBody User user) {

        userService.delete(user);

        return RestResp.ok("删除成功");
    }


    /**
     * 用户授权
     */
    @ApiOperation("用户授权")
    @RequestMapping(value = "/grant", method = RequestMethod.POST)
    @ResponseBody
    public RestResp grant(@RequestBody UserRoleVO userRoleVO) {
        userService.grant(userRoleVO);
        return RestResp.ok("授权成功！");
    }

    /**
     * token失效
     */
    @ApiOperation("注销")
    @RequestMapping(value = "/invalidate", method = RequestMethod.POST)
    @ResponseBody
    public RestResp invalidate(String token) {
        userService.invalidate(token);
        return RestResp.ok("");
    }


    /**
     * 校验是否存在角色
     */
    @ApiOperation("校验是否存在角色")
    @RequestMapping(value = "/checkRole", method = RequestMethod.POST)
    @ResponseBody
    public RestResp checkRole(@RequestBody CheckRoleVO checkRoleVO) {
        if(userService.checkRole(checkRoleVO)){
            return RestResp.ok("true");
        }else {
            return RestResp.ok("false");
        }
    }

    /**
     * 查询用户角色
     */
    @ApiOperation("查询用户角色")
    @RequestMapping(value = "/allRoles", method = RequestMethod.POST)
    @ResponseBody
    public RestResp allRoles(String token) {
        List<Role> roleList =  userService.allRoles(token);
        return RestResp.ok(JsonUtil.toJsonString(roleList));
    }

}
