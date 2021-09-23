package beauty.location;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：算法——出现k次和1次
 * 数组中只有一个数出现了1次，其他数都出现了k次
 * 输出只出现一次的数
 * <p>
 * 解题思路：
 * 2个相同的二进制数不进位相加等于0
 * 10个相同的十进制数不进位相加等于0
 * k个相同的K进制数不进位相加等于0
 *
 * @author RenShiWei
 * Date: 2020/3/4 18:54
 **/
public class 数组中出现k此与1次的数 {

    /**
     * 功能描述：查数组只出现一次的数
     *
     * @param arr 目标数组
     * @param k   其余数出现的次数
     * @return 只出现1次的数
     * @author RenShiWei
     * Date: 2020/3/4 19:39
     */
    private static int findOneNum ( int[] arr, int k ) {
        int len = arr.length;
        //存每个数组元素的k进制的每一位
        char[][] kRadix = new char[len][];
        //数字中转成k进制最长的长度
        int maxLen = 0;
        //遍历每个数字
        for (int i = 0; i < len; i++) {
            //求每个数字的k进制并反转，然后转为字符数组；
            // 反转——从低位进行不进位加法，保证位对齐
            kRadix[i] = new StringBuffer(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            //记录数字中转成k进制最长的长度
            if (kRadix[i].length > maxLen) {
                maxLen = kRadix[i].length;
            }
        }
        //进行不进位加法
        int[] resArr = new int[maxLen];
        for (int i = 0; i < len; i++) {
            //不进位加法
            for (int j = 0; j < maxLen; j++) {
                if (j >= kRadix[i].length) {
                    resArr[j] += 0;
                } else {
                    //char-'0'——char转为int类型
                    resArr[j] += (kRadix[i][j] - '0');
                }
            }
        }
        //将出现一次的数从k进制转为10进制
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            //(int)(Math.pow(k,i))——k的i次方
            res += (resArr[i]% k) * (int) (Math.pow(k, i));
        }
        return res;
    }

    /**
     * 功能描述：利用哈希表求解
     *
     * @author RenShiWei
     * Date: 2020/3/4 20:25
     */
    private static int findOneNum2 ( int[] arr ) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int value : arr) {
            if (arrMap.containsKey(value)) {
                arrMap.put(value, arrMap.get(value) + 1);
            } else {
                arrMap.put(value, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : arrMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main ( String[] args ) {
        int[] arr = {1, 1, 1, 2, 2, 2, 6, 5, 5, 5};
        System.out.println(findOneNum(arr, 3));
        System.out.println(findOneNum2(arr));

    }

}

