package com.github.marshalcn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.marshalcn.entity.SysPermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPermissionDao extends BaseMapper<SysPermissionEntity> {
    List<SysPermissionEntity> queryByUserId(@Param("userId") Long userId);
}
