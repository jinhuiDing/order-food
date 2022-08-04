package com.djh.orderfood.enums;

public enum ResponseEnum {
    SUCCESS(200,"成功"),
    ERROR(5000,"服务器错误");


    private int code;

    private String msg;

   private ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
