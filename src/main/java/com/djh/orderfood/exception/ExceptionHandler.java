package com.djh.orderfood.exception;

import com.djh.orderfood.model.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public BaseResponse<String> userNotFound(UserNotFoundException e) {
        return BaseResponse.errorWithMsg(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IncorrectPasswordException.class)
    public BaseResponse<String> incorrectPassword(IncorrectPasswordException e) {
        return BaseResponse.errorWithMsg(e.getMessage());
    }
}
