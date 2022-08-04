package com.djh.orderfood.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FoodPageParam extends PageParam {
    private String name;
}
