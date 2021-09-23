package beauty.test.mergesort;

import beauty.utils.Util;

import java.util.Arrays;

/**
 * 功能描述：算法-合并有序数组(逆序)
 * 给定两个排序后的数组A和B，其中A的末端有足够的缓冲空间容纳B。
 * 将B合并入A并排序
 *
 * @author RenShiWei
 * Date: 2020/3/24 17:49
 **/
public class 合并有序数组 {

    static int[] mergeArr ( int[] arrA, int[] arrB ) {
        //指向原A和B数组末尾的指针
        int a = arrA.length - 1, b = arrB.length - 1;
        //A扩容后，指向末尾的指针
        int[] arrAs = Arrays.copyOf(arrA, arrA.length + arrB.length);
        int help = arrAs.length - 1;

        while (help > 0) {
            arrAs[help--] = Math.max(arrAs[a], arrB[b]);
            if (arrAs[a] >= arrB[b]){
                a--;
            }else {
                b--;
            }
        }
        return arrAs;
    }

    public static void main ( String[] args ) {
        int[] arrA={1,2,6,8,45,566};
        int[] arrB={1,2,5,10,45,56,98,156};
        Util.printArr(mergeArr(arrA,arrB));
    }

}

