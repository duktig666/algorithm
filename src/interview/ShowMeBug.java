package interview;

public class ShowMeBug implements Runnable {

    private double balance; // 账户余额
    
    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(double money) {
        //请输入实现存钱逻辑
        synchronized (ShowMeBug.class) {
            balance += money;
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        //100个线程同时向一个银行账户中存入一元钱
        ShowMeBug showMeBug = new ShowMeBug();
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(showMeBug);
            t1.start();
        }

        System.out.println(showMeBug.getBalance());

    }

    @Override
    public void run() {
        deposit(1);
    }

}
