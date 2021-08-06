package offer;

import org.junit.Test;

/**
 * description:
 * 题目一：在一个长度为n的数组里的所有数字都在0～n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3（也可返回输出是否有重复数字）。
 * <p>
 * 题目二：不修改数组找出重复的数字
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,7},那么对应的输出是重复的数字2或者3。
 *
 * @author RenShiWei
 * Date: 2021/6/9 11:24
 **/
public class FindRepetitionNumber3 {
    /*
        题目一解题思路
        思路一：排序，扫描相邻数组元素是否相同  时间复杂度 O(nlogn)
        思路二：哈希表。数组元素为键，出现次数为值  时间复杂度为O(1) 空间复杂度为O(n)的哈希表
        前两种思路比较简单，就不在具体实现。主要实现下思路三

        利用数组解决问题时，可以尝试模拟哈希表 —— 数组索引为键，数组中的元素为值
     */

    /**
     * 思路三：
     * 规律：数组数字在0-1的范围内，如果没有重复的数字，说明： 排序后 数组下标 = 数组元素
     * <p>
     * 解题思路：
     * ①遍历数组，判断数组下标是否与元素值（用m标识）相同，相同判断下一个；如果不相同，与【数组元素值的下标元素，即arr[m]】判断。
     * ②如果相同（m == arr[m]），说明找到了重复元素；如果不相同，继续执行步骤①
     * ③如果遍历完，还未找到重复元素，说明数组无重复元素
     * <p>
     * 时间复杂度：O(n) 空间复杂度O(1)
     *
     * @param arr /
     * @return 是否有重复的数字
     */
    boolean duplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int i = 0;
        while (i < arr.length) {
            if (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    System.out.println("测试找出的重复的元素:" + arr[i]);
                    return true;
                } else {
                    swap(arr, i, arr[i]);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 交换数组的两个元素
     * 使用位运算，提高效率
     * <p>
     * int temp = arr[i];
     * arr[i] = arr[j];
     * arr[j] = temp;
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    @Test
    public void testDuplicate() {
        System.out.println("---题目一测试用例---");
        System.out.println(duplicate(new int[] {2, 3, 1, 0, 2, 5, 3}));
        System.out.println(duplicate(new int[] {3, 2, 1, 0, 5, 3}));
        System.out.println(duplicate(new int[] {2, 1, 0, 4, 3}));
    }

    /**
     * 题目二解题思路
     * 思路一：辅助数组。除了前面的哈希表外，可以使用辅助数组。将原数组的数组元素m，复制到辅助数组下标的m位置（出现一次+1），很容易计算重复的数字。
     * 时间复杂度 O(n)  空间复杂度O(n)
     * <p>
     * 思路二：二分查找法
     * mid为arr.length的中点，分为两部分，重复的数字的那部分的元素数量一定
     * 时间复杂度：进行logn次，每次O(n),总：O(nlogn) 空间复杂度：O(1)
     * 缺点：只能判断有重复，但是不能具体判断有哪些重复。时间换空间，一般不这样做。
     */
    public int getDuplication(int[] arr) {
        if (arr == null || arr.length == 0) {
            return - 1;
        }
        int l = 1, r = arr.length - 1;
        while (l <= r) {
            //位运算的优先级低于加减运算符
            int m = l + ((r - l) >> 1);
            //计算左半部分，l~m数组元素出现的次数
            int count = count(arr, l, m);
            //左右指针重叠，并且count有数组元素，说明当前元素必为重复的元素
            if (r == l) {
                if (count > 1) {
                    return l;
                } else {
                    break;
                }
            }
            //左边次数大，说明重复元素在左侧
            if (count > m - l + 1) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return - 1;
    }

    /**
     * 计算数组arr，从l到m的元素，出现的次数
     */
    public int count(int[] arr, int l, int m) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int value : arr) {
            if (value >= l && value <= m) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void testGetDuplication() {
        System.out.println("---题目二测试用例---");
        System.out.println(getDuplication(new int[] {2, 3, 5, 4, 3, 2, 7}));
        System.out.println(getDuplication(new int[] {2, 4, 6, 4, 2, 5, 3}));
        System.out.println(getDuplication(new int[] {3, 2, 1, 1, 5, 3}));
        System.out.println(getDuplication(new int[] {2, 1, 1, 4, 3}));
    }


}

