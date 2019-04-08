package com.itgo.web.controller.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;
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
@SpringCloudApplication
@EnableEurekaClient
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@ComponentScan(basePackages = {"com.itgo.web"})
@EnableFeignClients(basePackages = {"com.itgo.service.base"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
