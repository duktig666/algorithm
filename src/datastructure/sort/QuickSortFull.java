package datastructure.sort;

import java.util.Arrays;

/**
 * description:快速排序Java实现 @see https://blog.csdn.net/qq_42937522/article/details/104901049
 * <p>
 * 时间复杂度：最好、平均 O(nlogn) 最坏 O（n^2） 空间复杂度：O（1） 不稳定（远距离的调换元素）
 *
 * @author RenShiWei
 * Date: 2021/6/25 9:56
 **/
public class QuickSortFull {

    /**
     * 交换数组中两个元素的位置
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 随机主元法：
     * 取数组随机一个元素作为主元，防止到数组尾端 （如果需要以数组左侧第一个元素为主元，那么应将随机主元 与 l进行交换位置）
     */
    private static void randomPrimary(int[] arr, int l, int r) {
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
    }

    /**
     * 三点中值主元法：
     * 将数组中最左边，中间，最右边三个值对比，中值作为目标值
     * <p>
     * 还有一种方式为绝对中值主元法（不常用）：
     * 通过将待排序数组以5个元素分为一组，取中间值，取到整个数组的各组中间值，再将这些数排序，再取中间值作为主元。
     * 因为寻找绝对中值，也会花费时间，所以使用三点中值法居多。
     */
    private static void midValuePrimary(int[] arr, int l, int r) {
        //中间下标
        int midIndex = l + ((r - l) >> 1);
        //中间值下标
        int midValueIndex = - 1;
        if (arr[l] <= arr[midIndex] && arr[l] >= arr[r]) {
            midValueIndex = l;
        } else if (arr[r] <= arr[midIndex] && arr[r] >= arr[l]) {
            midValueIndex = r;
        } else {
            midValueIndex = midIndex;
        }
        //同理：根据情况，若要以最后一个元素为主元 那么 midValueIndex 与 r 进行交换
        swap(arr, l, midValueIndex);
    }

    /* ---------------单向/双向扫描法------------------ */

    /**
     * 使用快排对数组排序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 使用快排对指定索引区间的数组进行排序
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //三点中值法选取主元，放到数组末尾
            midValuePrimary(arr, l, r);
            int p = partitionByDoubleScannerLeft(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    /**
     * 单向扫描法：(以第一个元素为主元)
     * 双指针，单向扫描，并返回主元元素的下标
     *
     * @param arr /
     * @param l   /
     * @param r   /
     * @return 只有两个元素的数组，是等于主元的区间
     */
    private static int partitionBySingleScanner(int[] arr, int l, int r) {
        //以第一个元素为主元
        int pivot = arr[l];
        //扫描指针
        int less = l + 1;
        //右侧指针
        int more = r;
        while (less <= more) {
            if (arr[less] <= pivot) {
                //如果小于等于主元，左指针继续右移
                less++;
            } else {
                //如果大于主元，当前元素和右侧指针对应的元素交换位置
                swap(arr, less, more);
                more--;
            }
        }
        //左后将主元放在中间的临界值位置
        swap(arr, l, more);
        return more;
    }

    /**
     * 双向扫描法（左侧为主元）：
     * 双指针，双向扫描，并返回主元元素的下标
     *
     * @param arr /
     * @param l   /
     * @param r   /
     * @return 只有两个元素的数组，是等于主元的区间
     */
    public static int partitionByDoubleScannerLeft(int[] arr, int l, int r) {
        //以数组最左侧的值为目标值
        int pivot = arr[l];
        //扫描指针
        int less = l + 1;
        //右侧指针
        int more = r;
        while (less <= more) {
            //left不停的往右走，知道遇到大于主元的元素
            while (less <= more && arr[less] <= pivot) {
                //循环退出时，left一定指向第一个大于主元的元素
                less++;
            }
            while (less <= more && pivot < arr[more]) {
                //循环退出时，right一定指向第一个小于主元的元素
                more--;
            }
            if (less <= more) {
                swap(arr, less, more);
            }
        }
        //while退出时，两者交错，right一定指向第一个小于主元的元素
        swap(arr, l, more);
        return more;
    }

    /**
     * 双向扫描法（右侧为主元）：
     * 双指针，双向扫描，并返回主元元素的下标
     *
     * @param arr /
     * @param l   /
     * @param r   /
     * @return 只有两个元素的数组，是等于主元的区间
     */
    private static int partitionByDoubleScanner(int[] arr, int l, int r) {
        //主元为最后一个元素
        int pivot = arr[r];
        //less为左侧扫描指针，more为右侧扫描指针（最后一个元素为主元，所以减1）
        int less = l, more = r - 1;
        while (less < more) {
            //第一次循环，找到左边元素大于主元的停止
            while (less < more && arr[less] <= pivot) {
                less++;
            }
            //第二次循环，找到右边元素小于主元的停止
            while (less < more && arr[more] > pivot) {
                more--;
            }
            //上面两个循环都完毕，说明此时左边元素大于主元，右边元素小于主元，需要进行交换
            if (less < more) {
                swap(arr, less, more);
            }
        }
        //这里进行比较主要是可能出现主元为最大值，不用交换
        if (arr[more] > arr[r]) {
            //如果more大于主元，将主元与右侧的第一个元素交换位置
            swap(arr, more, r);
            //返回主元下标
            return more;
        }
        //此时的more即为主元所在的位置
        return r;
    }

    /* 三分法实现快排 */

    /**
     * 对整个数组快速排序（三分法）
     */
    public static void quickSortByThree(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSortByThree(arr, 0, arr.length - 1);
    }

    /**
     * 在数组的指定范围内进行快速排序（三分法）
     */
    public static void quickSortByThree(int[] arr, int l, int r) {
        if (l < r) {
            //三点中值法选取主元，放到数组末尾
            midValuePrimary(arr, l, r);
            int[] p = partitionByThreePart(arr, l, r);
            quickSortByThree(arr, l, p[0] - 1);
            quickSortByThree(arr, p[1] + 1, r);
        }
    }

    /**
     * 三分法，并返回主元元素的下边范围（与主元元素相等，且只有两个元素的数组）
     */
    private static int[] partitionByThreePart(int[] arr, int l, int r) {
        //less指针用来记录最后一个小于主元的元素位置；less指针+1到l指针为相等的元素，l指针用来扫描
        int less = l - 1;
        //more指针用来交换右侧，元素
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                //元素小于主元，与l指针的元素交换位置（如果l指针没找到与主元相同的元素，其实是与自己交换）
                swap(arr, ++ less, l++);
            } else if (arr[l] > arr[r]) {
                //元素大于主元，more与l指针的元素交换位置
                swap(arr, -- more, l);
            } else {
                //元素等于主元，l直接向后移动
                l++;
            }
        }
        //将主元与右侧第一个元素交换位置（必定大于等于主元）
        swap(arr, more, r);
        return new int[] {less + 1, more};
    }

    public static void main(String[] args) {
        System.out.println("---测试双向遍历法---");
        int[] arr = {1, 6, 2, 68, 5, 8, 45};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println("---测试三分法---");
        int[] arr3 = {1, 6, 2, 68, 5, 8, 45};
        quickSortByThree(arr3);
        System.out.println(Arrays.toString(arr3));
        int[] arr4 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        quickSortByThree(arr4);
        System.out.println(Arrays.toString(arr4));
    }

}

