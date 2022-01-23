package com.github.marshalcn.config;

import com.github.marshalcn.entity.AuthUser;
import com.github.marshalcn.entity.SysUserEntity;
import com.github.marshalcn.service.SysUserService;
import com.github.marshalcn.utils.SecureUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserAuthenticationManager implements AuthenticationManager {

    @Resource
    private SysUserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String presentedPassword = (String)authentication.getCredentials();
        UserDetails userDetails = null;
        // 根据用户名获取用户信息
        SysUserEntity sysUser = this.userService.loadUserByUsername(username);
        if (sysUser == null) {
            throw new BadCredentialsException("用户名不存在");
        } else {
            userDetails = new AuthUser(username, sysUser.getPasswd(), sysUser.getSalt(), AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
            // 自定义的加密规则，用户名、输的密码和数据库保存的盐值进行加密
            String encodedPassword = SecureUtil.encrypt(username, presentedPassword, sysUser.getSalt());
            if (authentication.getCredentials() == null) {
                throw new BadCredentialsException("登录名或密码错误");
            } else if (!this.passwordEncoder.matches(encodedPassword, userDetails.getPassword())) {
                throw new BadCredentialsException("登录名或密码错误");
            } else {
                UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userDetails, authentication.getCredentials(), userDetails.getAuthorities());
                result.setDetails(authentication.getDetails());
                return result;
            }
        }
    }
}
