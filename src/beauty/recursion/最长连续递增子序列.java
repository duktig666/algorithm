package beauty.recursion;

import beauty.utils.Util;

/**
 * 功能描述：算法——最长连续递增子序列
 * (1,9,2,5,7,3,4,6,8,0)中最长的递增子序列为(3,4,6,8)
 *
 * @author RenShiWei
 * Date: 2020/3/11 18:05
 **/
public class 最长连续递增子序列 {

    static int[] findIncreaseArr(int[] arr) {
        int begin = 0, end = 0;
        int length = 0;
        int helpL = 0, helpR = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (length < (end - begin)) {
                    length = end - begin;
                    helpL = begin;
                    helpR = end;
                }
                begin = i + 1;
                end = i + 1;
            } else {
                end++;
            }
        }
        //如果是排好序数组，重置helpL
        if (length == 0) {
            helpL = 0;
            helpR = arr.length - 1;
        }
        int[] help = new int[helpR - helpL + 1];
        for (int i = 0; i < help.length; i++) {
            help[i] = arr[helpL];
            helpL++;
        }
        return help;
    }

    public static void main(String[] args) {
//        int[] arr={1,9,2,5,7,3,4,6,8,0};
        int[] arr = {1, 2, 3, 4, 5};
        Util.printArr(findIncreaseArr(arr));
    }

}

