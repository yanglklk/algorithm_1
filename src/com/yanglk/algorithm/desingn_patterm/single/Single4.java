package com.yanglk.algorithm.desingn_patterm.single;
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 22:42 2020/5/7
 * @Param
 * @return
 *
 * 静态内部类
 * 静态内部类和非静态内部类一样，都不会因为外部内的加载而加载，
 * 同时静态内部类的加载不需要依附外部类，在使用时才加载，
 * 不过在加载静态内部类的过程中也会加载外部类
 **/
public class Single4 {
    // 构造方法私有
    private Single4(){

    }
    // 外部获取方法
    // 任何线程 调用getSingle1
    public static Single4 getSingle1(){
        return newSingle4.Instance;
    }
    //静态内部类 只能加载初始化一次
    //不依附外部类 使用时加载
    private static class newSingle4{
        static {
            System.out.println("tt");
        }
        private static Single4 Instance= new Single4();
    }

    public static void main(String[] args) {
//        Single4 single41=Single4.getSingle1();
//        Single4 single42=Single4.getSingle1();
//        System.out.println(single41);
//        System.out.println(single42);
        Single4 single4=new Single4();
    }

}
