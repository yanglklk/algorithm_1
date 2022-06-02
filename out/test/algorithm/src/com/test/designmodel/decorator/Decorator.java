package com.test.designmodel.decorator;

import com.test.designmodel.decorator.model.Shape;

public abstract class Decorator implements Shape{

    protected Shape shape;

    public Decorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
       shape.draw();
    }
}
