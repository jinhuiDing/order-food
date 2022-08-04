package com.djh.orderfood.service.impl;

import com.djh.orderfood.entity.Food;
import com.djh.orderfood.dao.FoodDao;
import com.djh.orderfood.model.FoodPageParam;
import com.djh.orderfood.service.FoodService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Food)表服务实现类
 *
 * @author makejava
 * @since 2022-07-30 08:32:09
 */
@Service("foodService")
public class FoodServiceImpl implements FoodService {
    @Resource
    private FoodDao foodDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Food queryById(Integer id) {
        return this.foodDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param food 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Food> queryByPage(FoodPageParam foodPageParam) {
       return  PageHelper.startPage(foodPageParam).doSelectPage(() -> foodDao.queryByName(foodPageParam.getName()));

    }

    /**
     * 新增数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    @Override
    public Food insert(Food food) {
        this.foodDao.insert(food);
        return food;
    }

    /**
     * 修改数据
     *
     * @param food 实例对象
     * @return 实例对象
     */
    @Override
    public Food update(Food food) {
        this.foodDao.update(food);
        return this.queryById(food.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.foodDao.deleteById(id) > 0;
    }
}
