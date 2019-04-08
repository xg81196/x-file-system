package com.itgo.web.config;

import com.itgo.web.interceptor.PlatformInterceptor;
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
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PlatformInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
