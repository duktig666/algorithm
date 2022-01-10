package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 自如 三面
 *
 * @author RenShiWei
 * Date: 2022/1/10 14:23
 **/
public class ZiRu {

    static List<ZiRu> sorts = new ArrayList<>();

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean isSwap = false;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
            if (! isSwap) {
                return;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

    public Integer reserve(Integer num) {
        StringBuilder sb = new StringBuilder(num.toString());
        return Integer.parseInt(sb.reverse().toString());
    }

    public Integer reserve2(Integer num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int temp = num % 10;
            num /= 10;
            sb.append(temp);
        }
        return Integer.parseInt(sb.toString());
    }

    public int reverse3(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bc");
        list.add("ac");
        list.stream().filter(str -> str.contains("a")).forEach(System.out::println);
    }

}

