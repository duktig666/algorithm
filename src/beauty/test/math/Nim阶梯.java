package beauty.test.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 功能描述：算法——Nim阶梯
 * 有n堆石子，每次可以从第i堆的石子中拿走一部分放到第i-1堆中，
 * 或者把第1堆中的石子拿走一部分，无法操作者算输。
 * <p>
 * 阶梯nim的游戏结果与只看奇数堆的石子数的普通nim结果相同。
 * <p>
 * 【证明】
 * 只需要考虑奇数的位置进行Nim游戏，因为石子在偶数位置是可以模仿操作的。 这是因为任何人移动了偶数层的石子后，另外一个人总是可以把他们再移到下一奇数层，那么奇数层拿到偶数层的石子就相当于是丢掉了。
 * 所以就变成了只有奇数层的Nim游戏。
 * <p>
 * 奇数阶梯上的石子异或起来，要是0，就先手必败，否则先手必胜
 *
 * @author RenShiWei
 * Date: 2020/4/8 17:34
 **/
public class Nim阶梯 {

    public static void main ( String[] args ) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        //num组数据，多少个堆
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            //每个堆有多少个石子
            arr[i] = input.nextInt();
        }
        int res = 0;
        //排列 不然可能输入的顺序会乱
        Arrays.sort(arr);
        if ((num & 1) == 1) {
            //num为奇数的情况下（堆的数量为奇数）
            for (int i = 0; i < arr.length; i += 2) {
                res ^= (i == 0) ? (arr[0] - 1) : (arr[i] - arr[i - 1] - 1);
            }
        } else {
            //num为偶数的情况下
            for (int i = 1; i < arr.length; i += 2) {
                res ^= (arr[i] - arr[i - 1] - 1);
            }
        }
        if (res == 0) {
            System.out.println("先手会输");
        } else {
            System.out.println("先手会赢");
        }
    }

}

