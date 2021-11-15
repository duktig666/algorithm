package leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * description: 215.数组中的第K个最大元素 @see https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author RenShiWei
 * Date: 2021/11/10 10:49
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class 数组中的第K个最大元素_215 {

    /**
     * 方法一：调用 api 直接破解
     */
    public int findKthLargestApi(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 方法二：容量为k的 堆排 思想 （手撕）
     */
    public int findKthLargestByHeap(int[] nums, int k) {
        // 构造大根堆
        buildMaxHeap(nums);
        // 待堆化的元素个数
        int size = k;
        while (size > 1) {
            //固定最大值（堆顶元素和末位元素交换位置）； size-1为未固定过的末尾元素索引（siz-1相当于临时变量，size本身未变化）
            swap(nums, 0, size - 1);
            //构造大根堆； --size：刚固定了一个最大值，将剩下的元素堆化（--size，先运算再赋值，size发生变化）
            heapify(nums, 0, -- size);
        }
        return nums[0];
    }


    /**
     * 构造成大根堆
     */
    private void buildMaxHeap(int[] arr) {
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
     * 堆顶元素下沉排序，将剩余的数构造成大根堆（通过顶端的数下降），
     *
     * @param arr   数组
     * @param index 当前元素索引
     * @param size  待堆化的数量
     */
    private void heapify(int[] arr, int index, int size) {
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

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 方法三： 使用优先队列 实现 基于 堆的解法
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    @Test
    public void test() {
        System.out.println(findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 5));
        System.out.println(findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

}

