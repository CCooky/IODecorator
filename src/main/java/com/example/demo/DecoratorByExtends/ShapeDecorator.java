package com.example.demo.DecoratorByExtends;

/**
 * 装饰器父类：将所有的方法均简单包装，为了减少代码冗余，让真正的装饰器类只用重写增强方法，其他方法不用动。
 * 第一点：如果直接让装饰器类去实现原生接口，也可以做到增强但是就必须重写所有方法、包括需要增强和不需要增强的，
 *       但是不需要增强的方法只是简单的包裹调用一下接口方法而已，这就显示代码很不美观
 *
 * 第二点：利用实现+继承的方式，可以超级方便写多个装饰器类，并且多个装饰器类还可以嵌套组合，不断增强！！！
 *      装饰器类和原始类继承/实现同样的父类，这样我们可以对原始类“嵌套”多个装饰器类
 */
public class ShapeDecorator implements Shape {

    public Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }

    @Override
    public void common() {
        shape.common();
    }

}
