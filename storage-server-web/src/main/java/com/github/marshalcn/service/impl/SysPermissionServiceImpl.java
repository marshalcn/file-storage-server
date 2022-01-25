package com.github.marshalcn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.marshalcn.dao.SysPermissionDao;
import com.github.marshalcn.entity.SysPermissionEntity;
import com.github.marshalcn.service.SysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermissionEntity> implements SysPermissionService {

    @Override
    public List<SysPermissionEntity> queryByUserId(Long userId) {
        return this.baseMapper.queryByUserId(userId);
    }
}
