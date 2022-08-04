package com.djh.orderfood.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Food)实体类
 *
 * @author makejava
 * @since 2022-07-30 08:32:07
 */
@Data
public class Food implements Serializable {

    private Integer id;
    /**
     * 菜品名称
     */
    private String name;
    /**
     * 菜品价格（分）
     */
    private Long price;
    /**
     * 菜品介绍
     */
    private String subject;
    /**
     * 菜品图片，多个以","分割
     */
    private String imgs;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;




}

