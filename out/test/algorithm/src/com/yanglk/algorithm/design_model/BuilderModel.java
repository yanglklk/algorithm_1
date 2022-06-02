package com.yanglk.algorithm.design_model;

import com.yanglk.algorithm.offer.Str;


public class BuilderModel {


    public static void main(String[] args) {
        A a=new A.Builder().a("asda").b("rrewf").build();
        System.out.println(a);
    }
}
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 12:01 2020/3/24
 * @Param
 * @return
 * 建造者模式 针对要创建复杂对象 创造有顺序或条件约束
 * 创建内部类 链式调用返回this 再build方法中返回对外部类的实例
 * lombok 实现
 **/
class A{
    private  String a;
    private  String b;
    private  String c;
    private  String d;

    public A(String a, String b,String c,String d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }

    static class Builder{
        private  String a;
        private  String b;
        private  String c;
        private  String d;

        public Builder a(String a){
            this.a=a;
            return this;
        }
        public Builder b(String a){
            this.b=a;
            return this;
        }
        public Builder c(String a){
            this.c=a;
            return this;
        }
        public Builder d(String a){
            this.d=a;
            return this;
        }
        public A build(){
            return new A(this.a,this.b,this.c,this.d);
        }

    }

    @Override
    public String toString() {
        return "a: "+this.a+" b: "+this.b+" c: "+this.c+" d: "+this.d;
    }
}