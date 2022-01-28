package com.github.marshalcn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.marshalcn.entity.SysUserTokenEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface SysUserTokenService extends IService<SysUserTokenEntity> {
    SysUserTokenEntity getByUserId(Long userId);
    UserDetails getByToken(String token);
}
