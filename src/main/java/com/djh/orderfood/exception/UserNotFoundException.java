package com.djh.orderfood.exception;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
        super("用户不存在!");
    }
}
