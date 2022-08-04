package com.djh.orderfood.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse <T>{
    private List<T> dataList;
    private Long total;

    public PageResponse(List<T> dataList,Long total){
        this.dataList=dataList;
        this.total=total;
    }
}
