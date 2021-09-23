package beauty.sort;

/**
 * 功能描述：算法——排序数组中找和的因子
 * -给定已排序数组arr和k ,不重复打印arr中所有相加和为k的不降序二元组
 * -如输入arr={-8,-4,-3,0,2,4,5,8,9,10},k=10
 * -输出(0,10)(2,8)
 * <p>
 * 扩展:三元组呢?
 *
 * @author RenShiWei
 * Date: 2020/3/28 16:32
 **/
public class 排序数组中找和的因子 {
    /*
        思路一：暴力破解，双重循环遍历数组元素，看每个元素是否有匹配元素的和为目标值
        算法复杂度为N^2，复杂度太高，舍弃
        没有利用到数组有序的条件
     */

    /**
     * 思路二：算法有序，可以利用二分查找法
     * - 目标值减去数组元素为目标和的因子
     * - 利用二分查找法，在剩余数组元素中查找是否存在
     * - 若存在，输出
     */
    public static void printSumK ( int[] arr, int k ) {
        //循环到倒数第二个元素
        for (int i = 0; i < arr.length - 1; i++) {
            //解决重复输出问题
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int temp = k - arr[i];
            if (binSearch(arr, i + 1, temp)) {
                printNum(arr[i], temp);
            }
        }
    }

    /**
     * 二分查找普通循环实现
     *
     * @param arr 目标数组
     * @param key 寻找的目标值
     * @return 是否找到
     */
    public static boolean binSearch ( int[] arr, int start, int key ) {
        int end = arr.length - 1;
        int mid = (end - start) / 2 + start;
        if (key == arr[mid]) {
            return true;
        }
//        int start = 0;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 按照题解输出
     */
    public static void printNum ( int i, int j ) {
        System.out.println("(" + i + "," + j + ")");
    }


    /**
     * 思路三：双向扫描法
     * - 定义两个指针，分别指向头部和尾部(left,right)
     * - 左右指针元素值的和与目标值对比
     * - 等于，输出，右指针左移
     * - 小于，左指针右移
     * - 大于，右指针左移
     * -左右指针重合时，结束
     */
    public static void printSumK2 ( int[] arr, int k ) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            //解决重复输出问题
            if (left > 0 && right < arr.length - 1) {
                if (arr[left] == arr[left - 1]){
                    left++;
                }
                if (arr[right] == arr[right + 1]){
                    right--;
                }
            }
            //判断输出
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                printNum(arr[left], arr[right]);
                left++;
            }
        }
    }

    public static void main ( String[] args ) {
        int[] arr = {-8, -4, -3, 0, 2, 2, 4, 5, 5, 8, 8, 9, 10, 13};
        int k = 10;
        printSumK(arr, k);
        System.out.println("方法二实现");
        printSumK2(arr, k);
    }
}

