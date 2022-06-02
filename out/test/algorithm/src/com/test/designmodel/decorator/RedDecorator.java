package com.test.designmodel.decorator;

import com.test.designmodel.decorator.model.Shape;

public class RedDecorator extends Decorator{

    public RedDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    // 增强对象功能
    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
