package com.test.designmodel.single;

public class DDLSingle {

    // volatile 是其他线程可见
    private static volatile DDLSingle ddlSingle;

    private DDLSingle() {
    }
    public static DDLSingle getInstance(){
        if (ddlSingle==null){
            synchronized (DDLSingle.class){
                if (ddlSingle==null){
                    ddlSingle=new DDLSingle();
                }
            }
        }
        return ddlSingle;
    }
}
