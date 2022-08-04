package com.djh.orderfood.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2022-07-31 13:42:36
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -47746885481379414L;

    private Integer id;

    private String username;

    private String password;
    /**
     * 昵称
     */
    private String nickName;


}

