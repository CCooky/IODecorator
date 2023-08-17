package com.example.demo.filterinterceptor;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 真正的装饰类，继承装饰类父类，重写需要增强的方法
 */
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final String requestBody;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public MyHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        // 通过流读取请求体数据，存储到成员属性
        ServletRequest req = getRequest();
        ServletInputStream inputStream = req.getInputStream();
        requestBody = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

    // 重写getInputStream方法即可
    @Override
    public ServletInputStream getInputStream() throws IOException {
        // 将字符串变成字节数组，然后传递给输入流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody.getBytes(StandardCharsets.UTF_8));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public void setReadListener(ReadListener listener) {}
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

}
