package beauty.test.mergesort;


/**
 * 功能描述：算法——逆序对的个数
 *  一个数列，如果左边数大，右边的数小，则称这两个数为一个逆序对。
 *      求出一个数列中有多少个逆序对。
 * @author RenShiWei
 * Date: 2020/3/24 18:27
 **/
public class 逆序对的个数 {
    public static int mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return  mergeSort(arr, 0, arr.length - 1);

    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        /*让左右两部分的元素先有序，然后将两个有序的部分合并成一个有序的数组
           那怎么让左边的部分和右边的部分有序？
           继续把左边的部分分为两部分，让左边的部分的两部分有序
           继续把右边的部分分为两部分，让右边的部分的两部分有序
         */
        return merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        //比较左右两部分的元素，哪个小，把那个元素填入help中
        while (p1 <= m && p2 <= r) {
            if(arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
                nixu += m-p1 + 1;
            }
        }
        //上面的循环退出后，把剩余的元素依次填入到help中
        //以下两个while只有一个会执行
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //把最终的结果复制给原数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return nixu;
    }

    public static void main(String[] args) {

        int[] arr = {7,5,6,4};
        System.out.println(mergeSort(arr));
        System.out.println(nixu);
    }
    static int nixu =0;
}
