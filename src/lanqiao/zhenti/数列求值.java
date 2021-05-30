package lanqiao.zhenti;

/**
 * description:
 * 第十届蓝桥杯题C
 *
 * @author RenShiWei
 * Date: 2020/10/7 10:44
 **/
public class 数列求值 {
    //4659
    public static void main(String[] args) {
        int len = 20190324;
        int temp1 = 1;
        int temp2 = 1;
        int temp3 = 1;
        int sum = 0;
        for (int i = 3; i < len; i++) {
            sum = temp1 + temp2 + temp3;
            sum %= 10000;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = sum;
        }
        System.out.println(temp3);
    }
}

