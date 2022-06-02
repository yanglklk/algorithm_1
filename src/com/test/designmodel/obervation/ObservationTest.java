package com.test.designmodel.obervation;

public class ObservationTest {

    public static void main(String[] args) {
        // 增加订单主题
        Subject subject =new AddSubject();

        // 微信 短线都订阅该主题
        Observor o1 = new ObservorA(subject);
        Observor o2 = new ObservorB(subject);
        subject.setStatus(12);
        subject.setStatus(34);

        // 不再订阅短信主题
        subject.romoveObervor(o1);
        subject.setStatus(44);

        // 减少订单
        Subject subject1 =new SubSubject();

        // 只有短信订阅
        Observor o3 = new ObservorA(subject1);

        subject1.setStatus(12);
        subject1.setStatus(34);

    }
}
