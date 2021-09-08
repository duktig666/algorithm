package datastructure.sort;

import java.util.Arrays;

/**
 * description:堆排序（完全二叉树）
 *
 * @author RenShiWei
 * Date: 2021/8/28 10:56
 **/
public class HeapSort {

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 构造大根堆
        buildMaxHeap(arr);
        // 待堆化的元素个数
        int size = arr.length;
        while (size > 1) {
            //固定最大值（堆顶元素和末位元素交换位置）； size-1为未固定过的末尾元素索引（siz-1相当于临时变量，size本身未变化）
            swap(arr, 0, size - 1);
            //构造大根堆； --size：刚固定了一个最大值，将剩下的元素堆化（--size，先运算再赋值，size发生变化）
            heapify(arr, 0, -- size);
        }
    }

    /**
     * 构造成大根堆
     */
    private static void buildMaxHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            //当前节点比父节点大，进行循环，到根节点或者子节点比父节点小结束
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                //当前节点索引改为父节点索引
                index = (index - 1) / 2;
            }
        }
    }

    /**
     * 构造成大根堆的详细版（帮助理解）
     */
    private static void buildMaxHeapDetail(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //当前插入的索引
            int currentIndex = i;
            //父结点索引
            int fatherIndex = (currentIndex - 1) / 2;
            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点。然后继续和上面的父结点值比较，直到不大于父结点，则退出循环。
            while (arr[currentIndex] > arr[fatherIndex]) {
                //交换当前结点与父结点的值
                swap(arr, currentIndex, fatherIndex);
                //将当前索引指向父索引
                currentIndex = fatherIndex;
                //重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }


    /**
     * 堆顶元素下沉排序，将剩余的数构造成大根堆（通过顶端的数下降），
     *
     * @param arr   数组
     * @param index 当前元素索引
     * @param size  待堆化的数量
     */
    private static void heapify(int[] arr, int index, int size) {
        // 左右孩子索引 （也可以只用left索引，right = left + 1，这里使用right比较直观）
        int left = 2 * index + 1, right = 2 * index + 2;
        // 判断是否越界
        while (left < size) {
            //右孩子不越界，并且比左孩子大；哪个值大，选择哪个孩子节点
            int largestIndex = right < size && arr[right] > arr[left] ? right : left;
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            largestIndex = arr[largestIndex] > arr[index] ? largestIndex : index;
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // -----------------基于小根堆排序实现（倒序）------------------


    /**
     * 堆排序（倒序实现，基于小根堆）
     */
    public static void heapSortDesc(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 构造大根堆
        buildMinHeap(arr);
        // 待堆化的元素个数
        int size = arr.length;
        while (size > 1) {
            //固定最大值（堆顶元素和末位元素交换位置）； size-1为未固定过的末尾元素索引（siz-1相当于临时变量，size本身未变化）
            swap(arr, 0, size - 1);
            //构造大根堆； --size：刚固定了一个最大值，将剩下的元素堆化（--size，先运算再赋值，size发生变化）
            heapifyDesc(arr, 0, -- size);
        }
    }


    /**
     * 构建小根堆
     */
    private static void buildMinHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            //当前节点比父节点小，进行循环，到根节点或者子节点比父节点大结束
            while (arr[index] < arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                //当前节点索引改为父节点索引
                index = (index - 1) / 2;
            }
        }
    }

    /**
     * 小根堆，堆顶元素依次下沉，重新构建排序
     *
     * @param arr   /
     * @param index 当前元素索引
     * @param size  待构建元素数量
     */
    private static void heapifyDesc(int[] arr, int index, int size) {
        // 左右孩子索引 （也可以只用left索引，right = left + 1，这里使用right比较直观）
        int left = 2 * index + 1, right = 2 * index + 2;
        // 判断是否越界
        while (left < size) {
            //右孩子不越界，那个值小选哪个
            int minIndex = right < size && arr[right] < arr[left] ? right : left;
            //比较父结点的值与孩子中较小的值，并确定最小值的索引
            minIndex = arr[minIndex] < arr[index] ? minIndex : index;
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == minIndex) {
                break;
            }
            //父结点不是最小值，与孩子中较小的值交换
            swap(arr, minIndex, index);
            //将索引指向孩子中较小的值的索引
            index = minIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println("---测试大根堆正序---");
        int[] arr = {35, 10, 26, 1, 15, 13, 28};
        heapSort(arr);
        // 1, 10, 13, 15, 26, 28, 35
        System.out.println(Arrays.toString(arr));

        System.out.println("---测试小根堆逆序---");
        int[] arr2 = {35, 10, 26, 1, 15, 13, 28};
        heapSortDesc(arr2);
        // 1, 10, 13, 15, 26, 28, 35
        System.out.println(Arrays.toString(arr2));
    }

}

