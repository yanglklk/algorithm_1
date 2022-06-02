package com.test.designmodel.proxy.model;

public class RealImage implements Image{
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFile();
    }

    @Override
    public void display() {
        System.out.println("display :"+this.filename);
    }

    public void loadFile(){
        System.out.println("loadFile :"+this.filename);
    }
}
