package com.shijiwei.shoppingmall.login.dao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@ApiModel("注册信息结构体")
public class UserDto {

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("昵称")
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @ApiModelProperty("年龄")
    @Min(value = 0, message = "用年龄不能为空且不为负")
    private int age;

    @ApiModelProperty("性别 0 ： 女 ， 1： 男")
    @Range(min = 0, max = 1, message = "性别不能为空,0 ： 女 ， 1： 男")
    private int sex;
}
