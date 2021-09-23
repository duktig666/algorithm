package beauty.test.quicksort;

import java.util.Arrays;

/**
 * 功能描述：算法——最小可用ID
 * 在非负数组（乱序）中找到最小的可分配的id（从1开始编号），数据量1000000
 * 数组从1开始，如果有数字缺席，即为最小可分配id
 * 有点像mysql的id字段找出最小的断层id
 *
 * @author RenShiWei
 * Date: 2020/3/24 16:48
 **/
public class 最小可用ID {

    /**
     * 解法1：暴力破解——从1开始查找是否在数组中存在
     */
    static int find1 ( int[] arr ) {
        int i = 1;
        while (true) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != i) {
                    return i;
                }
            }
            i++;
        }
    }

    /**
     * 解法2：先排序，然后依次查找
     * nlogn
     */
    static int find2 ( int[] arr ) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            if (i + 1 != arr[i]) {
                return i + 1;
            }
            i++;
        }
        return i + 1;
    }

    /**
     * 解法3：改进解法1，采用辅助空间（与原数组相同），遇到每个元素，判断是否存在
     */
    static int find3 ( int[] arr ) {
        //多开辟一个元素，从1开始
        int[] help = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            //可能出现1,2,3,4,5,1000这样的情况
            if (arr[i] < arr.length + 1) {
                help[arr[i]] = 1;
            }
        }
        for (int i = 1; i < help.length; i++) {
            if ((help[i] == 0)) {
                return i;
            }
        }
        //如果全部不断层，说明是数组的下一个元素
        return arr.length + 1;
    }

    /**
     * 解法4：分区递归思想
     */
    static int find4 ( int[] arr, int l, int r ) {
        if (l > r) {
            return l + 1;
        }
        //中间值下标
        int midIndex = l + ((r - l) >> 1);
        //实际在中间位置的值
        int q = 第k个元素.selectK(arr, l, r, midIndex - l + 1);
        //期望值
        int t = midIndex + 1;
        if (q == t) {
            //左侧紧密
            return find4(arr, midIndex + 1, r);
        } else {
            //右侧紧密
            return find4(arr, l, midIndex - 1);
        }

    }


}

