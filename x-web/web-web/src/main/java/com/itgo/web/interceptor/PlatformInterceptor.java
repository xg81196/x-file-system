package com.itgo.web.interceptor;

import com.itgo.utils.GsonUtil;
import com.itgo.utils.IpUtil;
import com.itgo.utils.ServiceResponse;
import com.itgo.vo.BaseBeanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        logger.info("<===========来自客户端 {"+IpUtil.getIp()+"} 的访问===========>");
        logger.info("<===========PlatformInterceptor.perHandle===========>");
        Method method = ((HandlerMethod) handler).getMethod();
//        Class<RequestData>[] types = (Class<RequestData>[]) method.getParameterTypes();
//        for (Class<RequestData> type : types) {
//            Field field = type.getDeclaredField("reqData");
//            field.setAccessible(true);
//            System.out.println(field.getType());
//            Object o = field.get(type);
//            BaseBeanVO data = (BaseBeanVO)o;
//            String msg  = data.check();
//            if("ok".trim().equals(msg.trim())){
//                return true;
//            }else {
//                ServiceResponse<BaseBeanVO> serviceResponse = new ServiceResponse<>();
//                serviceResponse.setRetMessage(msg);
//                serviceResponse.setRetCode("500");
//                serviceResponse.setRetContent(null);
//                returnData(response,serviceResponse);
//                return false;
//            }
//        }
        return true;
    }



    private void returnData(HttpServletResponse response, ServiceResponse<BaseBeanVO> data){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=utf-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date()));
        try {
            writer = response.getWriter();
            writer.print(GsonUtil.toJson(data));
        } catch (IOException e) {
            logger.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

