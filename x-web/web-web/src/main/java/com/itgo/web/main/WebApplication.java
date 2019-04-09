package com.itgo.web.main;

import com.itgo.utils.BeanUtil;
import com.itgo.web.config.WebApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Create by xb
 * The file is [ WebApplication] on [ x-file-system ] project
 * The file path is com.itgo.web.main.WebApplication
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/7 20:29
 * @description
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.itgo.service.base.api"})
@ComponentScan(basePackages = {"com.itgo.web","com.itgo.utils","com.itgo.bean","com.itgo.aop"})
@ServletComponentScan
@Import(WebApplicationConfig.class)
public class WebApplication {

    private static Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(WebApplication.class, args);
        //设置上下文
        BeanUtil.setApplicationContext(run);
        logger.info("web  start success");
    }



}
