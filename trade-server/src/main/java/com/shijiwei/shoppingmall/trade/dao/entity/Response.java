package com.shijiwei.shoppingmall.trade.dao.entity;

import lombok.Data;

@Data
public class Response<T> {

    static final int SUCCESSFUL = 1;
    static final int FAILED = 0;

    private int code;
    private String message;
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
