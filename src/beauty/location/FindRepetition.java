package beauty.location;

import beauty.utils.Util;

import java.util.Random;

/**
 * 功能描述：算法——位运算运用
 * 数组1-1000中（1001个数），有唯一一个重复的数，其他数只出现一次
 * 求重复的数
 * 要求数组元素只能访问一次，不使用辅助空间
 *
 * @author RenShiWei
 * Date: 2020/3/2 11:34
 **/
public class FindRepetition {

    /**
     * 功能描述：不使用辅助空间，数组元素只可访问一次，求出数组中重复的数
     *
     * @param arr 含有一个重复数的数组
     * @return 返回数组中唯一重复的数
     * @author RenShiWei
     * Date: 2020/3/2 11:38
     */
    public static int findRepetitionNum(int[] arr) {
        int x = 0;
        //将1-1000进行运算，得出结果
        for (int i = 1; i < arr.length; i++) {
            x = (x ^ i);
        }
        //将x（将1-1000进行运算的结果）和目标数组（1-1000，并且包含一个重复的数）进行^运算
        //前后抵消，只剩下那个重复的数
        for (int i = 0; i < arr.length; i++) {
            x = x ^ arr[i];
        }
        return x;
    }

    /**
     * 功能描述：暴力解题，利用额外数组
     *
     * @param arr 含有一个重复数的数组
     * @return 返回数组中唯一重复的数
     * @author RenShiWei
     * Date: 2020/3/2 15:38
     */
    public static int findRepetitionNumByViolence(int[] arr) {
        int[] help = new int[arr.length];
        for (int i = 0; i < help.length; i++) {
            help[arr[i]]++;
        }
        for (int i = 0; i < help.length; i++) {
            if (help[i] == 2) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 功能描述：创建否和题目的数组
     *
     * @author RenShiWei
     * Date: 2020/3/2 15:41
     */
    private static int[] createQuestionArr() {
        int n = 11;
        int[] arr = new int[n];
        //创建1-1000的数组，最后一个元素为null
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        //最后一位生成[1,1000]的随机数
        arr[arr.length - 1] = new Random().nextInt(n - 1) + 1;
        //产生随机下标,对应数组下标[0,1001)
        int index = new Random().nextInt(n);
        //重复的数随机交换位置，造成随机位置随机数重复
        Util.swap(arr, index, arr.length - 1);
        //将数组元素输出
        Util.printArr(arr);
        return arr;
    }

    /** test */
    public static void main(String[] args) {
        //测试找出唯一重复的数
        int[] test = {1, 2, 3, 4, 5, 2};
        System.out.println(findRepetitionNum(test));
        System.out.println(findRepetitionNum(createQuestionArr()));
        System.out.println(findRepetitionNumByViolence(createQuestionArr()));
        //测试找出唯一单独的数
        int[] test2 = {1, 1, 3, 3, 5};
        System.out.println(findOnlyNum(test2));
    }

    /**
     * 功能描述：在一个值均成对，只有一个单独存在的数组中，找出单独存在的数
     *
     * @param arr 一个值均成对，只有一个单独存在的数组
     * @return 单独存在的数
     * @author RenShiWei
     * Date: 2020/3/2 17:32
     */
    public static int findOnlyNum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] ^ arr[i - 1];
            if (i == arr.length - 1) {
                return arr[i];
            }
        }
        return 0;
    }

}

