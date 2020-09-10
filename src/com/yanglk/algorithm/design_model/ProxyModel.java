package com.yanglk.algorithm.design_model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyModel {
    public static void main(String[] args) {
        AA aa=new BB();
        AA test= (AA) Proxy.newProxyInstance(aa.getClass().getClassLoader(),aa.getClass().getInterfaces(),new ProxyTest(aa));
        int a=test.aa(2,4);
    }
}
interface AA {
    int  aa(int a,int b);
}
class BB implements AA{
    @Override
    public int aa(int a,int b) {
        System.out.println("aa method"+(a+b));
        return a+b;
    }
}
class ProxyTest implements InvocationHandler{
    public Object object;
    public ProxyTest(Object o){
        this.object=o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object rel=null;
        rel=method.invoke(object,args);
        after();
        return rel;

    }

    public void before(){
        System.out.println("开始执行");
    }
    public void after(){
        System.out.println("执行结束");
    }

}
