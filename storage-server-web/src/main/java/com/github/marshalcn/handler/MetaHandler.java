package com.github.marshalcn.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.marshalcn.entity.SysUserEntity;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;


public class MetaHandler implements MetaObjectHandler {
    private static final Logger logger = LoggerFactory.getLogger(MetaHandler.class);

    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        SysUserEntity userEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createUserId", userEntity.getLoginName(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
//        this.setFieldValByName("updateBy", userEntity.getLoginName(), metaObject);
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        SysUserEntity userEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", userEntity.getLoginName(), metaObject);
    }
}
