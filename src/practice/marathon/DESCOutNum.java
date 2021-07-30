package practice.marathon;

import java.util.Scanner;
import java.util.Stack;

/**
 * description:
 * 链接：https://ac.nowcoder.com/acm/contest/18874/1005
 * 来源：牛客网
 * 输入三个数，反序输出这三个数。
 * <p>
 * 输入描述:
 * 输入三个整数a, b , c 以空格隔开 0 <= a, b,c <= 2^{31}-1
 * 31
 * −1
 * 输出描述:
 * 输出一行，三个整数，以空格隔开
 *
 * @author RenShiWei
 * Date: 2021/7/30 21:10
 **/
public class DESCOutNum {

    public static void main(String[] args) {
        //可以使用数组，但是这里考虑使用栈来解决
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int i = 3;
        while (i-- > 0) {
            stack.push(sc.nextInt());
        }
        while (! stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}

