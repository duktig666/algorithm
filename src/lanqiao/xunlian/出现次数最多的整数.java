package lanqiao.xunlian;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/6/5 15:04
 **/
public class 出现次数最多的整数 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            // 这里真的坑，系统会输入一个0和-1！！！！
            return;
        }
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int minKey = 0, maxValue = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            int value = map.get(arr[i]);
            if (value > maxValue) {
                minKey = arr[i];
                maxValue=value;
            } else if (value == maxValue && arr[i] < minKey) {
                minKey = arr[i];
            }
        }
        System.out.println(minKey);
    }

}

