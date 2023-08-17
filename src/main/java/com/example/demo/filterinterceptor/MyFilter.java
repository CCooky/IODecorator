package com.example.demo.filterinterceptor;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Component
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("1、MyFilter 放行前，对request 数据进行处理");
        Map<String, String[]> parameterMap = servletRequest.getParameterMap(); //请求行数据可以直接反复读取
        printParameterMap(parameterMap);

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if ("POST".equals(httpServletRequest.getMethod())) {
            // 如果是post请求，则对请求体的输入流进行包装，并且往后传递
            MyHttpServletRequestWrapper myHttpServletRequestWrapper = new MyHttpServletRequestWrapper(httpServletRequest);
            filterChain.doFilter(myHttpServletRequestWrapper, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("2、MyFilter 放行后，对Response 数据进行处理");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void printParameterMap(Map<String, String[]> parameterMap) {
        System.out.println("下面是请求行的信息：");
        parameterMap.forEach((key, values) -> {
            String valueString = String.join(", ", values);
            System.out.println("Key: " + key + ", Values: " + valueString);
        });
    }
}
