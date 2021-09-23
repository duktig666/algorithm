package beauty.recursion;

import beauty.utils.Util;

/**
 * 功能描述：算法——希尔排序（插入排序的一种）
 * 也称缩小增量排序，是直接插入排序算法的一种更高效的版本。希尔排序是非稳定的排序算法
 * <p>
 * 思路：
 * 例如：序列 9 8 7 6 5 4 3 2 1
 * 1.确定一个增量序列，如4(length/2) 2 1,从大到小使用增量
 * 2.使用第一个增量，将序列划分为若干个子序列，下标组合为0-4-8,1-5,2-6,3-7
 * 依次对序列使用直接插入排序法
 * 3.使用第二个增量，将序列划分为若干个子序列(0-2-4-6-8),(1-3-5-7)
 * 依次对子序列使用直接插入排序法；
 * 4.使用第三个增量1，这时子序列就是元序列(0-1-2-3-4-5-6-7-8)，使用直接插入法
 * 完成排序
 * <p>
 * 时间复杂度：不太确定，在O(nlogn)~O(n^2)之间
 * 空间复杂度：O(1)
 * 原址排序
 * 稳定性：由于相同的元素可能会被划分至不同子序列单独排序，因此稳定性是无法保证的——不稳定
 * <p>
 * 思考：希尔排序为什么比插入排序速度快？
 * 如果原始数据的大部分元素已经排序，那么插入排序的速度很快（因为需要移动的元素很少）
 * 为什么快？
 * -无序的时候，元素少
 * -元素多的时候，已经基本有序
 *
 * @author RenShiWei
 * Date: 2020/3/8 9:35
 **/
public class 希尔排序 {

    /**
     * 希尔排序（插入排序升级版）
     */
    public static int[] shellSort(int[] arr) {
        if (arr.length > 0) {
            //不断缩小增量
            for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
                //增量为1的插入排序
                for (int i = interval; i < arr.length; i++) {
                    int target = arr[i];
                    int j = i - interval;
                    while (j > - 1 && target < arr[j]) {
                        arr[j + interval] = arr[j];
                        j -= interval;
                    }
                    arr[j + interval] = target;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 6, 7, 5, 3, 10};
        Util.printArr(shellSort(arr));
    }


}

