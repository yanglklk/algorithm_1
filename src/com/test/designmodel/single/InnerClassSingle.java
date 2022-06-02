package com.test.designmodel.single;

public class InnerClassSingle {
    private InnerClassSingle() {
    }

    //静态内部类，显示装载InnerClassSingle 不会加载Inner
    private static class Inner{
        private static InnerClassSingle single = new InnerClassSingle();
    }

    public static InnerClassSingle getInstance(){
        // 显式装载Inner才会加载
        return Inner.single;
    }
}
