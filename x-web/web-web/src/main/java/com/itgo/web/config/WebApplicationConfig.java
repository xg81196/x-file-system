package com.itgo.web.config;

import com.itgo.web.filter.AllInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Create by xb
 * The file is [ WebApplicationConfig] on [ x-file-system ] project
 * The file path is com.itgo.web.config.WebApplicationConfig
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/8 16:37
 * @description
 */
@Configuration
public class WebApplicationConfig extends WebMvcConfigurationSupport {


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(allInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public AllInterceptor allInterceptor(){
        return  allInterceptor();
    }
}