package com.djh.orderfood.exception;

public class IncorrectPasswordException extends BaseException {
    public IncorrectPasswordException() {
        super("密码错误!");
    }
}
