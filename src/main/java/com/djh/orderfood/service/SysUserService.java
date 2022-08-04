package com.djh.orderfood.service;

import com.djh.orderfood.entity.SysUser;
import com.djh.orderfood.model.param.UserPageParam;
import com.github.pagehelper.Page;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2022-07-31 13:42:36
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 分页查询
     *
     * @param sysUser     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SysUser> queryByPage(UserPageParam userPageParam);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据用户名查询
     * @param username 用户名
     * @return 用户对象
     */
    SysUser queryByUsername(String username);
}
