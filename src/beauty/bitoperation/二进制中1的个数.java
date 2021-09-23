package beauty.bitoperation;

import java.util.Scanner;

/**
 * 功能描述：算法——输入一个整数，输出该二进制表示中1的个数
 *
 * @author RenShiWei
 * Date: 2020/3/2 18:14
 **/
public class 二进制中1的个数 {

    /**
     * 功能描述：方法1——将1每次左移，判断整数每次左移的&运算，如果为1则+1
     *
     * @param n 目标整数
     * @return 二进制中1的个数
     * @author RenShiWei
     * Date: 2020/3/2 18:41
     */
    public static int sumOneCount1(int n) {
        int count = 0;
        //整数共32位
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == (1 << i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 功能描述：方法二——将整数每次右移进行&运算，如果为1则+1
     *
     * @param n 目标整数
     * @return 二进制中1的个数
     * @author RenShiWei
     * Date: 2020/3/2 18:41
     */
    public static int sumOneCount2(int n) {
        int count = 0;
        //整数共32位
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 功能描述：方法三
     * 每次进行-1操作，从低位到高位遇到的第一个1变0，其余0变1
     * 例如   10100  -1  -> 10011
     * (n - 1) & n,削掉最低位的1
     * 例如   (10100-1)&10100 -> 100000
     * 每循环一次，销掉一个1，次数+1，直至变为0.结束
     *
     * @param n 目标整数
     * @return 二进制中1的个数
     * @author RenShiWei
     * Date: 2020/3/2 18:41
     */
    public static int sumOneCount3(int n) {
        int count = 0;
        while (n != 0) {
            n = ((n - 1) & n);
            count++;
        }
        return count;
    }

    /** test */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(sumOneCount1(num));
        System.out.println(sumOneCount2(num));
        System.out.println(sumOneCount3(num));
    }
}
