package com.example.demo.DecoratorByExtends;


/**
 * 目标实现类，需要被增强的方法
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }

    @Override
    public void common() {
        System.out.println("这是一个通用的方法，我们不用增强，后面还有100个，我们只要增强一个");
    }
}
