package com.github.marshalcn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.marshalcn.dao.SysUserDao;
import com.github.marshalcn.entity.SysUserEntity;
import com.github.marshalcn.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Override
    public SysUserEntity loadUserByUsername(String username) {
        return this.baseMapper.queryByUserName();
    }
}
