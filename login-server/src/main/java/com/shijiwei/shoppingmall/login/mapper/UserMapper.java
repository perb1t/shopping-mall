package com.shijiwei.shoppingmall.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shijiwei.shoppingmall.login.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();
}
