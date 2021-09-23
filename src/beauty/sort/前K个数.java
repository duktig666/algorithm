package beauty.sort;

import beauty.utils.Util;

import java.util.Scanner;

/**
 * 功能描述：算法——前K个数
 * ➢求海量数据(正整数)按逆序排列的前k个数( topK) ,因为数据
 * 量太大,不能全部存储在内存中,只能-个一个地从磁盘或者网络
 * .上读取数据,请设计-个高效的算法来解决这个问题
 * <p>
 * ➢第一行:用户输入K ,代表要求得topK
 * ➢随后的N (不限制)行,每一行是一个整数代表用户输入的数据
 * ➢用户输入-1代表输入终止
 * ➢请输出topK ,从小到大,空格分割
 * <p>
 * ➢解决:
 * -大顶堆
 *
 * @author RenShiWei
 * Date: 2020/3/30 14:59
 **/
public class 前K个数 {
    //堆
    static int[] heap;
    static int index = 0;
    static int k;

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        heap = new int[k];
        int x = sc.nextInt();
        while (x != -1) {
            deal(x);
            x = sc.nextInt();
        }
        printRs();
    }

    private static void printRs () {
        Util.printArr(heap);
    }

    /**
     * 如果数据小于等于k，直接加入堆中
     * 等于k的时候进行堆化
     *
     * @param x
     */
    private static void deal ( int x ) {
        if (index < k) {
            //放x
            heap[index++] = x;
            if (index == k) {
                //如果够k个数，进行堆化
                minHeap(heap);
            }
        } else if (heap[0] < x) {
            //大于K
            //x和堆顶进行比较，如果x大于堆顶，x将堆顶挤掉并向下调整
            heap[0] = x;
            minHeapFixDown(heap, 0, k);
            printRs();
        }
    }

    public static void minHeap ( int[] A ) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapFixDown(A, i, n);
        }
    }

    public static void minHeapFixDown ( int[] A, int i, int n ) {
        //找到左右孩子
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 左孩子越界，i 就是叶子节点，返回
        if (left >= n) {
            return;
        }
        int min = left;
        // 右孩子越界，最小值为左孩子
        if (right >= n) {
            min = left;
        } else { //都没有越界，如果右孩子比左孩子小，那最小值为右孩子
            if (A[right] < A[left]) {
                min = right;
            }
        }
        //如果A[i]比两个孩子小，不用调整
        if (A[i] < A[min]) {
            return;
        }
        //否则，那个孩子小，那个和i 交换
        swap(A, i, min);
        //哪个孩子发生了变化，继续递归调整，直到子节点
        minHeapFixDown(A, min, n);
    }

    public static void swap ( int[] arr, int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

