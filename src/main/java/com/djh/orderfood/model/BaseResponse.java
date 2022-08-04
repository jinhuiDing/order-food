package com.djh.orderfood.model;

import com.djh.orderfood.enums.ResponseEnum;
import lombok.Data;

@Data
public class BaseResponse<T> {
    private T data;
    private Integer code;
    private String msg;


    public static <T> BaseResponse<T> successWithData(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMsg(ResponseEnum.SUCCESS.getMsg());
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> successWithoutData() {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMsg(ResponseEnum.SUCCESS.getMsg());
        return response;
    }

    public static <T> BaseResponse<T> error() {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseEnum.ERROR.getCode());
        response.setMsg(ResponseEnum.ERROR.getMsg());
        return response;
    }
    public static <T> BaseResponse<T> errorWithMsg(String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseEnum.ERROR.getCode());
        response.setMsg(msg);
        return response;
    }


}
