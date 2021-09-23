package beauty.sort;

/**
 * 功能描述：算法——需要排序的子数组
 * -给定一-个无序数组arr ,求出需要排序的最短子数组长度
 * -要求:
 * - O(N)
 * -如输入: arr={2,3,7,5,4,6}, 返回4 ,因为只有{7,5,4,6}需要排序
 *
 * @author RenShiWei
 * Date: 2020/3/28 17:36
 **/
public class 需要排序的子数组 {

    public static int findSortLength ( int[] arr ) {
        //定义两个指针记录需排序的区间索引
        int p1 = -1, p2 = -1;
        //记录高峰
        int max = arr[0], min = arr[arr.length - 1];
        //找右端点
        for (int i = 1; i < arr.length; i++) {

            if (i < arr.length - 1 && arr[i] > arr[i + 1] && p1 == -1) {
                p1 = i;
            }
            //记录最大值即为高峰
            if (arr[i] > max) {
                max = arr[i];
            }
            //低于历史高峰，扩展右端点
            if (arr[i] < max) {
                p2 = i;
            }
        }
        //找左端点
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > min) {
                p1 = i;
            }
        }
        if (p1 == -1) {
            return 0;
        }
        return 0;
    }

}

