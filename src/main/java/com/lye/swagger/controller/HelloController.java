package com.lye.swagger.controller;

import com.lye.swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "hello模块")
@RestController
@RequestMapping("api/v1/swagger")
public class HelloController {

    @ApiOperation(value = "输出hello", notes = "无需传参", response = String.class)
    @ApiResponses({
            @ApiResponse(code=200, message="添加成功"),
            @ApiResponse(code=500, message="系统异常")
    })
    @GetMapping (value = "")
    public String hello() {

        return "hello";
    }

    @ApiOperation(value = "用户信息", notes = "用户名和用户性别", response = User.class)
    @ApiResponses({
            @ApiResponse(code=200, message="添加成功"),
            @ApiResponse(code=500, message="系统异常")
    })
    @GetMapping(value = "/hello")
    public User hello(@ApiParam(value = "用户名") @RequestParam(value = "userName", required = true) String userName,
    @ApiParam(value = "用户性别") @RequestParam(value = "sex", defaultValue = "0", required = true) Integer sex) {
        System.out.println("userName:" + userName);
        System.out.println("sex:" + sex);
        return new User(userName, sex);
    }
}
