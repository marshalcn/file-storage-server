package com.github.marshalcn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.marshalcn.dao.SysUserTokenDao;
import com.github.marshalcn.entity.SysUserTokenEntity;
import com.github.marshalcn.service.SysUserService;
import com.github.marshalcn.service.SysUserTokenService;
import com.github.marshalcn.utils.RedisKeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private SysUserService userService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public SysUserTokenEntity getByUserId(Long userId) {
        return this.baseMapper.selectOne(new QueryWrapper<SysUserTokenEntity>().eq("user_id", userId));
    }

    @Override
    public UserDetails getByToken(String token) {
        UserDetails userDetails = getByTokenRedis(token);
        if (userDetails == null){
            SysUserTokenEntity tokenEntity = this.baseMapper.selectOne(new QueryWrapper<SysUserTokenEntity>().eq("token", token));
            userDetails = userDetailsService.loadUserByUsername(userService.getById(tokenEntity.getUserId()).getLoginName());
            this.setUserDetailsRedis(token, userDetails);
        }
        return userDetails;
    }

    private UserDetails getByTokenRedis(String token){
        return (UserDetails) redisTemplate.opsForValue().get(RedisKeyGenerator.getTokenKey(token));
    }
    private void setUserDetailsRedis(String token, UserDetails userDetails){
        redisTemplate.opsForValue().set(RedisKeyGenerator.getTokenKey(token), userDetails);
    }
}
