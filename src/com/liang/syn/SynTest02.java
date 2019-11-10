package com.liang.syn;

public class SynTest02 {

    public static void main(String[] args) {
        Account ac = new Account(100, "结婚礼金");
        DrawingSyn wife = new DrawingSyn(ac, 50, "happy");
        DrawingSyn you = new DrawingSyn(ac, 30, "可悲的你");

        wife.start();
        you.start();
    }
}


// 模拟取款
class DrawingSyn extends Thread {
    Account account;
    int drawingMoney;
    int packetTotal;

    public DrawingSyn(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }

    // 锁定account
    private void test() {
        // 提高性能
        if (account.money <= 0) {
            return;
        }

        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println("不够用");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "---->账户余额:" + account.money);
            System.out.println(this.getName() + "---->口袋余额:" + packetTotal);
        }
    }
}
