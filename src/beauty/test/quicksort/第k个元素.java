package beauty.test.quicksort;

/**
 * 功能描述：算法——第k个元素
 * 以尽量高的效率求出一个乱序数组中按数值顺序的第k个元素的值
 *
 * @author RenShiWei
 * Date: 2020/3/24 15:02
 **/
public class 第k个元素 {

    static int selectK ( int[] arr, int l, int r, int k ) {
        //主元的下标
        int q = partition2(arr, l, r);
        //主元是第几个元素
        int qK = q - l + 1;
        if (qK == k) {
            return arr[q];
        } else if (qK > k) {
            return selectK(arr, l, q - 1, k);
        } else {
            return selectK(arr, q + 1, r, k - qK);
        }
    }

    private static int partition2 ( int[] arr, int l, int r ) {
        //以第一个元素为主元
        int pivot = arr[l];
        //扫描指针
        int less = l + 1;
        //右侧指针
        int more = r;
        while (less <= more) {
            while (less <= more && arr[less] <= pivot) {
                less++;
            }
            while (less <= more && arr[more] > pivot) {
                more--;
            }
            if (less <= more) {
                swap(arr, less, more);
            }
        }
        swap(arr, l, more);
        return more;
    }

    public static void swap ( int[] arr, int i, int j ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main ( String[] args ) {
        int[] arr = {5, 6, 8, 4, 3, 55, 9};
        System.out.println("第k个元素");
        int k = selectK(arr, 0, arr.length - 1, 3);
        System.out.println(k);
    }

}

