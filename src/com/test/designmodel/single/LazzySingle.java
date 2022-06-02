package com.test.designmodel.single;

public class LazzySingle {

    private static LazzySingle lazzySingle = null;
    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    private LazzySingle(Integer a) {
        this.a = a;
    }
    // synchronized 保证线程安全
    public static synchronized LazzySingle getInstance(int a){
        if (lazzySingle==null){
            lazzySingle=new LazzySingle(a);
        }
        return lazzySingle;
    }

}
