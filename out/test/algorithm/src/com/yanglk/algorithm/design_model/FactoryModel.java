package com.yanglk.algorithm.design_model;

public class FactoryModel {
    public static void main(String[] args) {
        Application app=new MysqlApp();
        Connection connection=app.getConection();
        connection.connected();
        Command command=app.getCommand();
        command.command();

    }
}
/*
 * @Author yanglk
 * @Description //TODO
 * @Date 11:33 2020/3/24
 * @Param
 * @return
 *
 * 工厂模式，抽取变与不变 变化的大多是类级产生的实例 不变的是方法
 * 抽象出公共接口 在接口中定义规范
 * 实现类进行方法的具体实现
 * 用到的时候到工厂中取
 * 拓展开放 修改关闭 再增加oracle 不影响mysql
 **/
interface Connection{
    void connected();
}
interface Command{
    void command();
}
interface Application{
    Connection getConection();
    Command getCommand();
}

class  MysqlConnect implements Connection{
    @Override
    public void connected() {
        System.out.println("mysql connected");
    }
}

class MysqlCommand implements Command{
    @Override
    public void command() {
        System.out.println("mysql Command");
    }
}

class MysqlApp implements Application{


    @Override
    public Connection getConection() {
        return new MysqlConnect();
    }

    @Override
    public Command getCommand() {
        return new MysqlCommand();
    }
}