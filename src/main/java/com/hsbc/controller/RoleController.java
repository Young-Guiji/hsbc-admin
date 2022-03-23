package com.hsbc.controller;

import com.hsbc.model.RestResp;
import com.hsbc.model.Role;
import com.hsbc.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 角色控制器
 *
 * @author Xieboyun
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;


    /**
     * 添加角色
     *
     * @return
     */
    @ApiOperation("添加角色")
    @RequestMapping(method = RequestMethod.POST)
    public RestResp add(@RequestBody Role role) {
        roleService.add(role);
        return RestResp.ok("添加成功！");
    }

    /**
     * 删除角色
     *
     * @param role
     * @return
     */
    @ApiOperation("删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RestResp delete(@RequestBody Role role) {

        roleService.delete(role);
        return RestResp.ok("删除成功！");
    }


}
