package com.djh.orderfood.controller;

import com.djh.orderfood.entity.Food;
import com.djh.orderfood.entity.SysUser;
import com.djh.orderfood.model.BaseResponse;
import com.djh.orderfood.model.PageResponse;
import com.djh.orderfood.model.param.UserPageParam;
import com.djh.orderfood.service.SysUserService;
import com.github.pagehelper.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2022-07-31 13:42:35
 */
@RestController
@RequestMapping("sys/user")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;


    @GetMapping
    public BaseResponse<PageResponse<SysUser>> queryByPage(UserPageParam userPageParam) {
        Page<SysUser> page = this.sysUserService.queryByPage(userPageParam);
        return BaseResponse.successWithData(new PageResponse<>(page.getResult(),page.getTotal()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BaseResponse<SysUser> queryById(@PathVariable("id") Integer id) {
        return BaseResponse.successWithData(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping
    public BaseResponse<SysUser> add(@RequestBody SysUser sysUser) {
        return BaseResponse.successWithData(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public BaseResponse<SysUser> edit(SysUser sysUser) {
        return BaseResponse.successWithData(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public BaseResponse<Boolean> deleteById(@PathVariable("id") Integer id) {
        return BaseResponse.successWithData(this.sysUserService.deleteById(id));
    }

}

