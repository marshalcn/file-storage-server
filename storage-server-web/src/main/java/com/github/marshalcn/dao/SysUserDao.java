package com.github.marshalcn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.marshalcn.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    SysUserEntity queryByUserName(@Param("userName") String userName);
}
