package com.github.marshalcn.service.impl;

import com.github.marshalcn.entity.AuthUser;
import com.github.marshalcn.entity.SysUserEntity;
import com.github.marshalcn.service.SysUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private SysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity user = sysUserService.loadUserByUsername(username);
        if (user == null){
            return null;
        }
        return AuthUser.builder()
                .username(user.getLoginName())
                .password(user.getPasswd())
                .salt(user.getSalt())
                .disabled(user.getStatus() != 1)
                .accountExpired(user.getStatus() == -1)
                .credentialsExpired(false)
                .accountLocked(user.getStatus() == 2)
                .build();
    }
}
