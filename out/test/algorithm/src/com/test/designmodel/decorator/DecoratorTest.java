package com.test.designmodel.decorator;

import com.test.designmodel.decorator.model.Circle;
import com.test.designmodel.decorator.model.Shape;

public class DecoratorTest {

    public static void main(String[] args) {
        Shape shape = new Circle();
        RedDecorator redDecorator = new RedDecorator(shape);
        redDecorator.draw();
    }
}
