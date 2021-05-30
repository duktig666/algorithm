package lanqiao.zhenti;

import java.util.HashMap;
import java.util.Scanner;

/**
 * description:
 * 蓝桥杯第十届题G
 *
 * @author RenShiWei
 * Date: 2020/10/8 15:19
 **/
public class 外卖店优先级 {

    public static void main(String[] args) {
//        solve1();
        solve2();
    }

    static void solve1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int[][] arr = new int[n + 1][t + 1];
        int[] res = new int[n + 1];
        //t时刻，n号店，有几个订单
        while (m-- > 0) {
            int ts = sc.nextInt();
            int id = sc.nextInt();
            if (ts <= t) {
                arr[id][ts]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                // i代表店铺，j代表时刻
                if (arr[i][j] == 0) {
                    //此时刻，此店铺没有订单
                    if (res[i] > 0) {
                        res[i]--;
                    }
                } else {
                    res[i] += arr[i][j] * 2;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 5) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    static void solve2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int[][] arr = new int[n + 1][t + 1];
        int[] count = new int[n + 1];
        //作为优先缓存
        HashMap<Integer, Integer> shopMap = new HashMap<>();
        //t时刻，n号店，有几个订单
        while (m-- > 0) {
            int ts = sc.nextInt();
            int id = sc.nextInt();
            if (ts <= t) {
                arr[id][ts]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                // i代表店铺，j代表时刻
                if (arr[i][j] == 0) {
                    //此时刻，此店铺没有订单
                    if (count[i] > 0) {
                        count[i]--;
                    }
                } else {
                    count[i] += arr[i][j] * 2;
                }

                //判断优先级数，确定是否加入优先缓存
                if (count[i] > 5) {
                    //当店铺优先级数首次大于5时将其加入优先缓存中
                    shopMap.put(i, 1);
                } else if (count[i] <= 3) {
                    //当店铺已经加入到优先缓存且优先级数小于等于3时，剔除出去
                    shopMap.remove(i);
                }
            }
        }
        //此时map的大小即为优先缓存中的店铺数量
        System.out.println(shopMap.size());
    }

}

