package com.djh.orderfood.service;

import com.djh.orderfood.entity.Food;
import com.djh.orderfood.model.FoodPageParam;
import com.github.pagehelper.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Food)表服务接口
 *
 * @author makejava
 * @since 2022-07-30 08:32:08
 */
public interface FoodService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Food queryById(Integer id);

    /**
     * 分页查询
     *
     * @param food 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Food> queryByPage(FoodPageParam foodPageParam);

    /**
     * 新增数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    Food insert(Food food);

    /**
     * 修改数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    Food update(Food food);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
