package com.itgo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Create by xb
 * The file is [ BeanConfig] on [ x-file-system ] project
 * The file path is com.itgo.config.BeanConfig
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/8 14:35
 * @description
 */
@Configuration
public class BeanConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }


}
