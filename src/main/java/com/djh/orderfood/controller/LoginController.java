package com.djh.orderfood.controller;

import com.djh.orderfood.entity.SysUser;
import com.djh.orderfood.exception.IncorrectPasswordException;
import com.djh.orderfood.exception.UserNotFoundException;
import com.djh.orderfood.model.BaseResponse;
import com.djh.orderfood.service.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {

    private final SysUserService userService;

    public LoginController(SysUserService userService) {
        this.userService = userService;
    }


    @PostMapping("login")
    @ResponseBody
    public BaseResponse<SysUser> login(@RequestBody SysUser user) {

        SysUser sysUser = this.userService.queryByUsername(user.getUsername());
        if (Objects.isNull(sysUser))throw new UserNotFoundException();
        if (!user.getPassword().equals(sysUser.getPassword())) {
            throw new IncorrectPasswordException();
        }
        return BaseResponse.successWithData(sysUser);
    }

}
