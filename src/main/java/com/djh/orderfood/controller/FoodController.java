package com.djh.orderfood.controller;

import com.djh.orderfood.entity.Food;
import com.djh.orderfood.model.BaseResponse;
import com.djh.orderfood.model.FoodPageParam;
import com.djh.orderfood.model.PageResponse;
import com.djh.orderfood.service.FoodService;
import com.github.pagehelper.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Food)表控制层
 *
 * @author makejava
 * @since 2022-07-30 08:32:02
 */
@RestController
@RequestMapping("food")
public class FoodController {
    /**
     * 服务对象
     */
    @Resource
    private FoodService foodService;

    @GetMapping
    public BaseResponse<PageResponse<Food>> queryByPage(FoodPageParam foodPageParam) {
        Page<Food> foodPage = this.foodService.queryByPage(foodPageParam);
        return BaseResponse.successWithData(new PageResponse<>(foodPage.getResult(),foodPage.getTotal()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Food> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.foodService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param food 实体
     * @return 新增结果
     */
    @PostMapping

    public BaseResponse<Food> add( @RequestBody Food food) {
        this.foodService.insert(food);
        return BaseResponse.successWithoutData();

    }

    /**
     * 编辑数据
     *
     * @param food 实体
     * @return 编辑结果
     */
    @PutMapping
    public BaseResponse<Food> edit(Food food) {
        return BaseResponse.successWithData(this.foodService.update(food));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id) {
        this.foodService.deleteById(id);
        return BaseResponse.successWithoutData();
    }

}

