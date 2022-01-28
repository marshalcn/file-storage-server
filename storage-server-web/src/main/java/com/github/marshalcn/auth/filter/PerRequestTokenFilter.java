package com.github.marshalcn.auth.filter;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.marshalcn.service.SysUserTokenService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PerRequestTokenFilter extends OncePerRequestFilter {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private SysUserTokenService userTokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // 获取AuthorizationToken
            String authorization = getAuthorization(request);
            // 从缓存中获取用户信息
            UserDetails userDetails = (UserDetails)redisTemplate.opsForValue().get(authorization);
            if (userDetails == null){

            }
            Assert.notNull(userDetails,"登录已过期请重新登录");

            // 构建AuthenticationToken
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // 把AuthenticationToken放到当前线程,表示认证完成
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        } catch (SecurityException e) {
            response.getWriter().print(e);
        }
    }
    public String getAuthorization(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }else {
            throw new SecurityException("invalid token");
        }
    }
}
