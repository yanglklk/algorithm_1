package com.test.designmodel.proxy;

import com.test.designmodel.proxy.model.Image;
import com.test.designmodel.proxy.model.ProxyImage;
import com.test.designmodel.proxy.model.RealImage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // 装饰器模式为了增强功能，而代理模式是为了加以控制。
        // StaticProxy();
        //  Proxy.newProxyInstance 使用实现类的 getClassLoader() 和 getInterfaces()
        DynamicProxy3();

    }

    private static void StaticProxy() {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }

    private static void DynamicProxy() {
        Image image = new RealImage("222");
        Image image1= (Image) Proxy.newProxyInstance(image.getClass().getClassLoader(), image.getClass().getInterfaces(), new MyInvokeHandler(image));
        image1.display();
    }

    private static void DynamicProxy3() {
        System.out.println(RealImage.class.getClassLoader());
        System.out.println(Image.class.getClassLoader());

        System.out.println(RealImage.class.getInterfaces());
        System.out.println(Image.class.getInterfaces());


        Image image1= (Image) Proxy.newProxyInstance(RealImage.class.getClassLoader(), RealImage.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----");
                return method.invoke(new RealImage("11231231"),args);
            }
        });
        image1.display();
    }

    private static void DynamicProxy2() {
        //Image image = new RealImage("222");
        Image image1= (Image) Proxy.newProxyInstance(RealImage.class.getClassLoader(), RealImage.class.getInterfaces(), new MyInvokeHandler(new RealImage("234")));
        image1.display();
    }

    private static void DynamicProxy1() {
        Image image = new RealImage("222");
        Image image1= (Image) Proxy.newProxyInstance(image.getClass().getClassLoader(), image.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----");
                return method.invoke(image,args);
            }
        });
        image1.display();
        System.out.println(image.getClass());
        System.out.println(image1.getClass());
    }
}

class MyInvokeHandler implements InvocationHandler{

    private Image image;

    public MyInvokeHandler(Image image) {
        this.image = image;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----");
        return method.invoke(image,args);
    }
}
