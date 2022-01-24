package com.github.marshalcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author madechao
 * @menu
 * @description
 * @createTime 14:07 2022/1/14
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class FileStorageServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileStorageServerApplication.class, args);
    }
}
