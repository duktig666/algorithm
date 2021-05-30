package lanqiao.jichu;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/18 16:10
 **/
public class 特殊数字153 {

    public static void main ( String[] args ) {
        int a = 0, b = 0, c = 0;
        for (int i = 100; i < 1000; i++) {
            //取百位数字
            a=i/100;
            //取十位数字
            b=i%100/10;
            //取个位数字
            c=i%10;
            if (i==a*a*a+b*b*b+c*c*c){
                System.out.println(i);
            }
        }
    }

}

