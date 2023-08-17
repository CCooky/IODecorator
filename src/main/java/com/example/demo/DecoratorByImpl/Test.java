package com.example.demo.DecoratorByImpl;

public class Test {
    public static void main(String[] args) {

        Shape shape = new Rectangle();
        shape.draw();

        //
        System.out.println();
        RectangleDecorator decorator = new RectangleDecorator(shape);
        decorator.draw();


    }
}
