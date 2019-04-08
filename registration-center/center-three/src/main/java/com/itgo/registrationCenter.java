package com.itgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Create by xb
 * The file is [ registrationCenter] on [ x-file-system ] project
 * The file path is com.itgo.registrationCenter
 *
 * @versio 1.0.o
 * @Author he ming xi
 * @date 2019/3/14 10:45
 * @description
 *      springcloud eureka注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class registrationCenter {
    public static void main(String[] args) {
        SpringApplication.run(registrationCenter.class,args);
    }
}
