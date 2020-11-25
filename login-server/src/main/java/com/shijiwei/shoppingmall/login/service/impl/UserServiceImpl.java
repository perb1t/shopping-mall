package com.shijiwei.shoppingmall.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shijiwei.shoppingmall.login.dao.dto.UserDto;
import com.shijiwei.shoppingmall.login.dao.req.LoginReq;
import com.shijiwei.shoppingmall.login.dao.vo.UserVo;
import com.shijiwei.shoppingmall.login.entity.Response;
import com.shijiwei.shoppingmall.login.entity.User;
import com.shijiwei.shoppingmall.login.mapper.UserMapper;
import com.shijiwei.shoppingmall.login.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Response register(UserDto userDto) {

        User userRet = userMapper.selectOne(new QueryWrapper<User>()
                .eq("user_name", userDto.getUserName())
        );

        if (userRet != null) {
            return Response.buildFailedResponse("用户名已存在");
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userMapper.insert(user);
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userDto, userVo);
            return Response.buildSuccessResponse(userVo);
        }
    }

    @Override
    public User login(LoginReq req) {
        User user = userMapper.selectOne(new QueryWrapper<User>()
                .eq("user_name", req.getUserName())
                .eq("password", req.getPassword())
        );
        return user;
    }
}
