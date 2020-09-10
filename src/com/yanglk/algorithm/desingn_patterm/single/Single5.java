package com.yanglk.algorithm.desingn_patterm.single;
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 22:56 2020/5/7
 * @Param 
 * @return
 *
 * 使用枚举方法
 * 枚举类中 构造方法是私有的(默认）
 **/
public enum Single5 {
    SINGLE_5("luck","aa/bcd",12l);
    private String name;
    private Long id;
    private String url;
    private Single5(String name, String url, Long id){
        this.name=name;
        this.url=url;
        this.id=id;
    }

    public static void main(String[] args) {
        Single5 single51=Single5.SINGLE_5;
        Single5 single52=Single5.SINGLE_5;
        System.out.println(single51==single52);
        System.out.println(single52.hashCode());
    }
}
