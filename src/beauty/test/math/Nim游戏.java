package beauty.test.math;

/**
 * 功能描述：算法——Nim游戏
 *  一共有N堆石子， 编号1..n ,第i堆中有个a[i]个石子。
 * 每一次操作Alice和Bob可以从任意-堆石子 中取出任意数量的石子,
 * 至少取一-颗,至多取出这一堆剩下的所有石子。
 * 两个人轮流行动,取光所有石子的一-方获胜。Alice为先手。
 *
 * 给定a,假设两人都采用最优策略谁会获胜?
 *
 * 思路:（最佳策略）所有数进行异或，如果为0，则输；如果为1，则赢
 *      证明省略
 * @author RenShiWei
 * Date: 2020/4/8 16:35
 **/
public class Nim游戏 {

    static boolean sovle(int[] arr){
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            res^=arr[i];
        }
        return res!=0;
    }

    public static void main ( String[] args ) {
        int[] arr={3,4,5};
        System.out.println(sovle(arr));
    }


}

