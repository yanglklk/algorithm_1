package com.test.jvmTest.lockTest;

public class AddMoneyThread implements Runnable{

    private Account account;
    private Integer add;


    public AddMoneyThread(Account account, Integer add) {
        this.account = account;
        this.add = add;
    }

    @Override
    public void run() {
        account.addMoney0(add);
    }
}
