package com.itgo.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by xb
 * The file is [ ControllerInterceptor] on [ x-file-system ] project
 * The file path is com.itgo.web.filter.ControllerInterceptor
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/8 16:05
 * @description
 */
@Component
public class AllInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(AllInterceptor.class);

    /**
     * controller之前处理，进行拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        String data = requestWrapper.getData();
        return super.preHandle(request, response, handler);
    }

    /**
     * controller处理完毕，还没有渲染视图，进行拦截
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     *
     *整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     *如性能监控中我们可以在此记录结束时间并输出消耗时间，
     *还可以进行一些资源清理，类似于try-catch-finally中的finally，
     *但仅调用处理器执行链中
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
