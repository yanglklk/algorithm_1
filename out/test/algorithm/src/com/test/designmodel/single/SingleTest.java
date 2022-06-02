package com.test.designmodel.single;

import com.alibaba.fastjson.JSON;

public class SingleTest {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(LazzySingle.getInstance(12)));
        System.out.println(JSON.toJSONString(EHanSingle.getInstance(2234)));

    }
}
