package com.shijiwei.shoppingmall.login.entity;

import lombok.Data;

@Data
public class User {

    private int userId;
    private String userName;
    private String password;
    private String nickName;
    private int age;
    private int sex;
}
