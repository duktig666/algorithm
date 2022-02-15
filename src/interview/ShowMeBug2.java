package interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2022/2/14 21:33
 **/
public class ShowMeBug2 implements Runnable {


    private AtomicInteger balance = new AtomicInteger();


    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(int money) {
        balance.addAndGet(money);
    }

    /**
     * 获得账户余额
     */
    public int getBalance() {
        return balance.get();
    }

    public static void main(String[] args) {
        //100个线程同时向一个银行账户中存入一元钱
        ShowMeBug showMeBug = new ShowMeBug();
//        for (int i = 0; i < 100; i++) {
//            Thread t1 = new Thread(showMeBug);
//            t1.start();
//        }

    }

    @Override
    public void run() {
        deposit(1);
        System.out.println(getBalance());
    }

}

