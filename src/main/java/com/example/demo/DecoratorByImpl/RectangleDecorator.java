package com.example.demo.DecoratorByImpl;

public class RectangleDecorator implements Shape {
    private Shape shape;

    public RectangleDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
        System.out.println("我在这里对方法进行了加强！");
    }

    @Override
    public void common() { //这个100个普通方法全部要重写，很麻烦，如果再加一个装饰器类也要这样
        shape.common();
    }
}
