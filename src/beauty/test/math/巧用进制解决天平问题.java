package beauty.test.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 功能描述：算法——巧用进制解决天平问题
 * ➢天平称重:变种3进制
 * 用天平称重时,我们希望用尽可能少的砝码组合称出尽可能多的重量。
 * 如果有无限个砝码，但它们的重量分别是1, 3, 9，R7. 81, ...等3的指数幂
 * 神奇之处在于用它们的组合可以称出任意整数重量(砝码允许放在左右两个盘
 * 中)。
 * 本题目要求编程实现:对用户给定的重量,给出砝码组合方案,重量< 1000000。
 * 例如:
 * 用户输入:
 * 5
 * 程序输出：
 * 9 -3 -1
 *
 * @author RenShiWei
 * Date: 2020/4/8 15:32
 **/
public class 巧用进制解决天平问题 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //转换成三进制
        final String x = Integer.toString(n, 3);
        //翻转后转成字符数组，方便从低位到高位进行遍历
        char[] arr = new StringBuilder(x).reverse().toString().toCharArray();
        //定义集合，存储
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            //插入时，往前插，是因为前边是高位，恢复是比较好恢复
            if (arr[i] == '2') {
                //-1插在开头
                list.add(0, -1);
                //插入后进位
                if (i == arr.length - 1) {
                    //遍历到数组的最后一位
                    list.add(0, 1);
                } else {
                    //否则对下一个数字+1（进位）
                    ++arr[i + 1];
                }
            } else if (arr[i] == '3') {
                //0插在开头
                list.add(0, 0);
                //更高位进1
                if (i == arr.length - 1) {
                    //遍历到数组的最后一位
                    list.add(0, 1);
                } else {
                    ++arr[i + 1];
                }
            } else {
                //如是1或者0，直接转成数字插入
                list.add(0, arr[i] - '0');
            }
        }
        //恢复十进制
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                sb.append("+").append((int) Math.pow(3, list.size() - i - 1));
            }
            if (list.get(i) == -1) {
                sb.append("-").append((int) Math.pow(3, list.size() - i - 1));
            }
        }
        System.out.println(sb.substring(1));
    }

}

