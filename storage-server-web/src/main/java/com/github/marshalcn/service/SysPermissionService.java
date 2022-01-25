package com.github.marshalcn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.marshalcn.entity.SysPermissionEntity;

import java.util.List;

public interface SysPermissionService extends IService<SysPermissionEntity> {
    List<SysPermissionEntity> queryByUserId(Long userId);
}
