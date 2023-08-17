package com.example.demo.filterinterceptor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;



@Component
public class MyInterceptor implements HandlerInterceptor {
    @Resource
    private Gson gson;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 使用现有的工具类
        if ("POST".equals(request.getMethod())) {
            StringBuilder stringBuilder = new StringBuilder();
            ServletInputStream inputStream = request.getInputStream();
            // 使用现有的工具类读取
            String requestBody = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            // json串序列化
            Type type = new TypeToken<Map<String, Object>>() {}.getType();
            Map<String, Object> map = gson.fromJson(requestBody, type);
            System.out.println(map);
        }

        return true;


//        if ("POST".equals(request.getMethod())) {
//            StringBuilder stringBuilder = new StringBuilder();
//            ServletInputStream inputStream = request.getInputStream();
//            // 读取字节数组返回（每次读取一桶水）
//            byte[] buffer = new byte[1024];
//            int read;
//            while ((read = inputStream.read(buffer)) != -1) {
//                stringBuilder.append(new String(buffer, 0, read, StandardCharsets.UTF_8));
//            }
//            String requestBody = stringBuilder.toString();
//            // json串序列化
//            Type type = new TypeToken<Map<String, Object>>() {}.getType();
//            Map<String, Object> map = gson.fromJson(requestBody, type);
//            System.out.println(map);
//        }
//        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }


}

