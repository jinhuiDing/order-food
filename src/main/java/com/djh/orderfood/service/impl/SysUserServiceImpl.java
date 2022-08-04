package com.djh.orderfood.service.impl;

import com.djh.orderfood.entity.SysUser;
import com.djh.orderfood.dao.SysUserDao;
import com.djh.orderfood.model.param.UserPageParam;
import com.djh.orderfood.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2022-07-31 13:42:36
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysUser     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysUser> queryByPage(UserPageParam userPageParam) {
        return PageHelper.startPage(userPageParam).doSelectPage(() -> this.sysUserDao.query(userPageParam.getUsername()));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserDao.deleteById(id) > 0;
    }

    @Override
    public SysUser queryByUsername(String username) {

        return this.sysUserDao.queryByUsername(username);
    }
}
