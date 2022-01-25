package com.github.marshalcn.config;

import com.github.marshalcn.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdGeneratorWorkerConfig {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1,1);
    }
}
