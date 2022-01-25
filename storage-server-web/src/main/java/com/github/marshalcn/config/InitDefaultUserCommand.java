package com.github.marshalcn.config;

import com.github.marshalcn.entity.SysUserEntity;
import com.github.marshalcn.service.SysUserService;
import com.github.marshalcn.util.IdWorker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Component
public class InitDefaultUserCommand implements CommandLineRunner {
    @Resource
    private IdWorker idWorker;
    @Resource
    private SysUserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        if (userService.countUser() == 0){
            SysUserEntity defaultUser = new SysUserEntity();
            defaultUser.setId(idWorker.nextId());
            defaultUser.setLoginName("admin");
            defaultUser.setUserName("admin");
            defaultUser.setPassword(passwordEncoder.encode("admin"));
            defaultUser.setSalt(UUID.randomUUID().toString().replaceAll("-", ""));
            defaultUser.setCreateUserId(0L);
            defaultUser.setCreateTime(new Date());
            defaultUser.setUpdateTime(new Date());
            userService.save(defaultUser);
        }
    }
}
