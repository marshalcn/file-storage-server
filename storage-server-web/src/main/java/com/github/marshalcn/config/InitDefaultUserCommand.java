package com.github.marshalcn.config;

import com.github.marshalcn.entity.SysUserEntity;
import com.github.marshalcn.service.SysUserService;
import com.github.marshalcn.utils.SecureUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class InitDefaultUserCommand implements CommandLineRunner {
    @Resource
    private SysUserService userService;
    @Override
    public void run(String... args) throws Exception {
        if (userService.countUser() == 0){
            SysUserEntity defaultUser = new SysUserEntity();
            defaultUser.setId(UUID.fromString("admin").toString());
            defaultUser.setLoginName("admin");
            defaultUser.setUserName("admin");
            defaultUser.setPasswd(SecureUtil.md5("admin"));
            defaultUser.setSalt(UUID.randomUUID().toString());
            userService.save(defaultUser);
        }
    }
}
