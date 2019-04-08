package com.itgo.service.base.realize.main;

import com.itgo.utils.BeanUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Create by xb
 * The file is [ BaseApplication] on [ x-file-system ] project
 * The file path is com.itgo.service.base.realize.main.BaseApplication
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/7 10:14
 * @description
 */
@SpringBootApplication(scanBasePackages = {"com.itgo.service.base.realize"})
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"com.itgo.service.base.api"})
@ComponentScan(basePackages = {"com.itgo.service.base.realize","com.itgo.utils","com.itgo.bean"})
@EnableEurekaClient
@MapperScan({"com.itgo.mapper","com.itgo.service.base.realize.mapper"})
public class BaseApplication {

    private static Logger logger = LoggerFactory.getLogger(BaseApplication.class);


    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(BaseApplication.class, args);
        //设置上下文
        BeanUtil.setApplicationContext(run);
        logger.info("base service start success");
    }

}
