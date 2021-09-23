package beauty.recursion;

/**
 * 功能描述：算法——递归实现排序
 * 对数组排序——>转化为对数组的部分排序
 * 插入排序：递归思想，将数组的最后一个元素插入到有序的部分当中
 *
 * @author RenShiWei
 * Date: 2020/3/7 14:43
 **/
public class 递归实现排序 {

    static void insert ( int[] arr, int k ) {
        if (k == 0) {
            return;
        }
        //递归，每次排好前半部分元素
        insert(arr, k - 1);
        //辅助变量，对每次最后一个元素进行排序
        int x = arr[k];
        int index = k - 1;
        //循环遍历，当前元素大于前一个元素，则结束循环
        while (index > -1 && x < arr[index]) {
            //若当前元素小于前一个元素，则当前元素替换成前一个元素
            arr[index + 1] = arr[index];
            index--;
        }
        //将遍历到的索引位置的元素，设为当前元素
        arr[index] = x;
    }

}

