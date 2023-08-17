package com.example.demo;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public String hello(@RequestBody HelloRequest request) {
        System.out.println(request);
        return "前端访问成功！！";
    }

}
