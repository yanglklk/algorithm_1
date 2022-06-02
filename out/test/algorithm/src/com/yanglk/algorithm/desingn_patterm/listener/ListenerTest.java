package com.yanglk.algorithm.desingn_patterm.listener;

public class ListenerTest {

    public static void main(String[] args) {

        AEvent event =new AEvent("123", new Listener<Integer>() {
            @Override
            public void invoke(Integer data) {
                System.out.println(data*2);
            }
        });

        event.setInteger(12);
        event.print();

        // classA 这里是父类引用 不论是extend 还是implements 都只能掉父类方法。
        InterFaceA classA = new ClassA();
        classA.ss();
    }
}
