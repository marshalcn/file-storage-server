package com.github.marshalcn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.marshalcn.entity.SysUserEntity;

public interface SysUserService extends IService<SysUserEntity> {
    SysUserEntity loadUserByUsername(String username);
}
