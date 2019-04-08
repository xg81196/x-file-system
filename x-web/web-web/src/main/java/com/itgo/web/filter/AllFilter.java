package com.itgo.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Create by xb
 * The file is [ ChannelFilter] on [ x-file-system ] project
 * The file path is com.itgo.web.filter.ChannelFilter
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/8 16:19
 * @description
 */
@Component
@WebFilter(urlPatterns = "/*",filterName = "allFilter")
public class AllFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(AllFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("<========初始化信息=======>");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if(servletRequest instanceof HttpServletRequest) {
            requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        }
        if(requestWrapper == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }

    @Override
    public void destroy() {
        logger.info("<========关闭项目=======>");
    }
}
