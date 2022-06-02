package com.test.designmodel.single;

// 枚举类 只加载一次，线程安全 且已经序列化
public enum EnumSingle {

    SINGLE(1);

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    EnumSingle(Integer id) {
        this.id = id;
    }

}
