package com.yanglk.algorithm.desingn_patterm.strategy;

/*
 * @Author yanglk
 * @Description //TODO
 * @Date 12:02 2020/5/8
 * @Param
 * @return
 *
 * 策略模式
 * 对可以替换的算法 不使用if else 选择
 * 而是将算法抽取成类 选择相关策略来执行 要将所有策略暴露出去
 * 上下文承上启下 客户端直接调用 内部执行对应策略中的方法
 *
 **/

public class StrategyTest {


    public static void main(String[] args) {
        Context context=new Context(new AddStrategy());
        System.out.println("5+10="+context.executeStrategy(5,10));
        context=new Context(new SubStrategy());
        System.out.println("5-10="+context.executeStrategy(5,10));
    }
}

// 抽象的策略
interface Strategy{
    int doOption(int a,int b);
}
// 具体的实施策略 算法
class AddStrategy implements Strategy{
    @Override
    public int doOption(int a, int b) {
        return a+b;
    }
}
class SubStrategy implements Strategy{
    @Override
    public int doOption(int a, int b) {
        return a-b;
    }
}
class MulStrategy implements Strategy{
    @Override
    public int doOption(int a, int b) {
        return a*b;
    }
}

// 上下文
// 根据外部调用要使用的策略 执行相关策略中的方法 算法
// 承上启下
// 其实外部使用者也可以使用相关的策略的方法
// 加入上下文之后 外部直接和上下文交互 降低交互难度 保持整体性

class Context{
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public int executeStrategy(int a,int b){
        return this.strategy.doOption(a,b);
    }
}
