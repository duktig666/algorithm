package beauty.recursion;

/**
 * 功能描述：算法——二分查找（拆半查找）
 *
 * @author RenShiWei
 * Date: 2020/3/8 9:27
 **/
public class 二分查找递归实现 {

    static int search(int[] arr, int num) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (num == arr[mid]) {
                return mid;
            } else if (num > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return - 1;
    }

    static int search2(int[] arr, int start, int end, int num) {
        if (start > end) {
            return - 1;
        }
        int mid = start + (end - start) / 2;
        if (num == arr[mid]) {
            return mid;
        } else if (num > mid) {
            return search2(arr, mid + 1, end, num);
        } else {
            return search2(arr, start, mid - 1, num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 25, 36, 58};
        System.out.println(search(arr, 10));
        System.out.println(search2(arr, 0, arr.length - 1, 10));
    }

}

