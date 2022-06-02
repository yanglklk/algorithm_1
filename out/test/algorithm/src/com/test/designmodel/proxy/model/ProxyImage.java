package com.test.designmodel.proxy.model;

public class ProxyImage implements Image{

    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage==null){
            realImage = new RealImage(this.filename);
        }
        realImage.display();
    }
}
