package com.example.demo.DecoratorByExtends;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Rectangle();
        shape.draw();
        shape.common();

        System.out.println();

        // enhance
        Shape shapeDecorator = new RectangleDecorator(shape);
        shapeDecorator.draw();
        shapeDecorator.common();


    }
}
