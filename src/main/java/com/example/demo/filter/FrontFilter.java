package com.example.demo.filter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午3:03
 * @Description: front filter
 * @Version 1.0
 */
public class FrontFilter extends BaseFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    protected String checkTokenOrSession(HttpServletRequest httpRequest) throws Exception {
        return null;
    }

}
