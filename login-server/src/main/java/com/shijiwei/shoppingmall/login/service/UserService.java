package com.shijiwei.shoppingmall.login.service;

import com.shijiwei.shoppingmall.login.dao.dto.UserDto;
import com.shijiwei.shoppingmall.login.dao.req.LoginReq;
import com.shijiwei.shoppingmall.login.entity.Response;
import com.shijiwei.shoppingmall.login.entity.User;

public interface UserService {

    Response register(UserDto userDto);

    User login(LoginReq req);
}
