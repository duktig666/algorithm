package lanqiao.jichu;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/18 16:16
 **/
public class 回文数 {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 1000; i < 10000; i++) {
            //取千位
            a = i / 1000;
            //取百位
            b = i % 1000 / 100;
            //取十位
            c = i % 100 / 10;
            //取个位
            d = i % 10;
            if (a == d && b == c) {
                System.out.println(i);
            }
        }
    }

    void f2() {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i * 1000 + j * 100 + j * 10 + i);
            }
        }
    }

}

