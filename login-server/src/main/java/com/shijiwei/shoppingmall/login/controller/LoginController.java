package com.shijiwei.shoppingmall.login.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.shijiwei.shoppingmall.login.dao.dto.UserDto;
import com.shijiwei.shoppingmall.login.dao.req.LoginReq;
import com.shijiwei.shoppingmall.login.dao.vo.UserVo;
import com.shijiwei.shoppingmall.login.entity.Response;
import com.shijiwei.shoppingmall.login.entity.User;
import com.shijiwei.shoppingmall.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "用户信息管理")
@RestController
public class LoginController {


    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "通过用户名和密码登录")
    @ResponseBody
    public Response login(@ApiParam(value = "登录结构体", required = true) @RequestBody LoginReq req) {
        if (StringUtils.isBlank(req.getUserName()) || StringUtils.isBlank(req.getPassword())) {
            return Response.buildFailedResponse("账号或密码不能为空");
        }

        User user = userService.login(req);
        if (user == null) {
            return Response.buildFailedResponse("账号不存在或密码错误");
        } else {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            return Response.buildSuccessResponse(userVo);
        }

    }

    @PostMapping("/register")
    @ApiOperation(value = "注册", notes = "账号注册")
    @ResponseBody
    public Response register(@ApiParam(value = "注册信息结构体", required = true)@RequestBody @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasErrors()) {
                for (ObjectError error : bindingResult.getAllErrors()) {
                    return Response.buildFailedResponse(error.getDefaultMessage());
                }
            }
        }
        return userService.register(userDto);
    }
}
