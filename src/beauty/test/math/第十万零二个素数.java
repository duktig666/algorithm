package beauty.test.math;

import static java.lang.Math.log;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/11 17:11
 **/
public class 第十万零二个素数 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        findNum(100000);
        System.out.println("耗时" + (System.currentTimeMillis() - now) + "ms");

        int cnt = 0;
        long x = 2;
        while (cnt < 100000) {
            if (素数测试.isPrime(x)) {
                cnt++;
            }
            x++;
        }
        System.out.println("耗时" + (System.currentTimeMillis() - now) + "ms");
    }

    static void findNum(int num) {
        /*
            num是第num个素数
            已知在整数X内大约有   X/log(X)  个素数
            逆推：求第num个素数，正式范围是？
            length代表整数范围
         */
        int length = 2;
        while (length / log(length) < num) {
            length++;
        }
        /*
            开辟一个数组，下标是自然数，值是标记
            基本思路是筛选法，把非素数标记出来
         */
        int[] arr = new int[length];
        int x = 2;
        while (x < length) {
            //记过了，下一个
            if (arr[x] != 0) {
                x++;
                continue;
            }

            int k = 2;
            //对每个x，我们从2倍开始，对x的k倍，全部标记为-1
            while (x * k < length) {
                arr[x * k] = - 1;
                k++;
            }
            x++;
        }

        //筛完之后，这个这个很长的数组里面  非素数的下标是-1
        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            //是素数，计数+1
            if (arr[i] == 0) {
                sum++;
            }
            if (sum == length) {
                System.out.println(i);
                return;
            }
        }
    }
}

