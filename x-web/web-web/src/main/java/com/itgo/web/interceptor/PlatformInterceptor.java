package com.itgo.web.interceptor;

import com.itgo.handler.ControllerHandler;
import com.itgo.utils.IpUtil;
import org.bouncycastle.util.IPAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by xb
 * The file is [ PlatformInterceptor] on [ x-file-system ] project
 * The file path is com.itgo.web.interceptor.PlatformInterceptor
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/8 20:13
 * @description
 */
@Component
public class PlatformInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(PlatformInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("------来自客户端 "+IpUtil.getIp()+" 的访问");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

