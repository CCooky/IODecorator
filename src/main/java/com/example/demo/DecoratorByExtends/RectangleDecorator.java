package com.example.demo.DecoratorByExtends;

public class RectangleDecorator extends ShapeDecorator{

    public RectangleDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        System.out.println("真正的装饰器类，对该方法进行增强");
        super.draw();
    }
}
