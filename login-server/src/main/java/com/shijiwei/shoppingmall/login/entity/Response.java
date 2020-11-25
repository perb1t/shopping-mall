package com.shijiwei.shoppingmall.login.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("请求响应结构体")
public class Response<T> {

    static final int SUCCESSFUL = 1;
    static final int FAILED = 0;

    @ApiModelProperty("SUCCESSFUL = 1,FAILED = 0")
    private int code;

    @ApiModelProperty("提示信息")
    private String message;

    @ApiModelProperty("数据结构")
    private T data;

    public Response() {
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> buildSuccessResponse(T t) {
        return new Response(SUCCESSFUL, "successfual", t);
    }

    public static <T> Response<T> buildFailedResponse(T t) {
        return new Response(FAILED, "failed", t);
    }
}
