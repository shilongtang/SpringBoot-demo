package com.example.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午3:02
 * @Description: admin filter 其中@Order注解表示执行过滤顺序，值越小，越先执行
 * @Version 1.0
 */
@Slf4j
//@Order(1)
//@WebFilter(filterName = "adminFilter", urlPatterns = "/admin/*")
public class AdminFilter extends BaseFilter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    protected String checkTokenOrSession(HttpServletRequest httpRequest) throws Exception {
        return null;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("1231313213123123");
        super.doFilter(servletRequest, servletResponse, filterChain);
    }
}
