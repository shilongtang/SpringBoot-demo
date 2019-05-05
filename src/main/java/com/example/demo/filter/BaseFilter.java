package com.example.demo.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: 青菜
 * @Date: 2019/4/30 下午3:46
 * @Description:
 * @Version 1.0
 */
@Slf4j
public abstract class BaseFilter implements Filter {

    /**
     * 校验token或者session
     * @param httpRequest
     * @return
     * @throws Exception
     */
    protected abstract String checkTokenOrSession(HttpServletRequest httpRequest) throws Exception;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        try {
            String checkRes = checkTokenOrSession(httpRequest);
            if(StringUtils.isNotEmpty(checkRes)){
                servletResponse.setContentType("text/html;charset=UTF-8");
                servletResponse.getWriter().write(JSONObject.toJSONString("{\"123\":\"123\"}"));
                StringBuffer requestURL = httpRequest.getRequestURL();
                log.info("requestURI:" +requestURL+" "+"requestURL:"+requestURL);
                return;
            } else {
                filterChain.doFilter(httpRequest, servletResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
