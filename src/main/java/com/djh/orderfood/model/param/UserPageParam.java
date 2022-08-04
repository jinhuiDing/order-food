package com.djh.orderfood.model.param;

import com.djh.orderfood.model.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserPageParam extends PageParam {
    private String username;
}
