package com.test.designmodel.single;

public class EHanSingle {
    // 显示装载时
    // 类加载时就已经创建 占有内存 线程安全
    private static EHanSingle lazzySingle = new EHanSingle(1);
    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    private EHanSingle(Integer a) {
        this.a = a;
    }
    public static EHanSingle getInstance(int a){
        lazzySingle.setA(a);
        return lazzySingle;
    }
}
