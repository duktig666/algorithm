package lanqiao.jichu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/20 15:45
 **/
public class 分解质因数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Map<Integer, String> map = new HashMap<>();
        for (int i = a; i <= b; i++) {
            //如果是素数先添加到map中
            if (isPrime(i)) {
                System.out.println(i + "=" + i);
            } else {
                printPrime(i, primeFactor(i));
            }
        }


    }

    /**
     * 测试num是否为素数
     * 在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数
     */
    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 分解质因数
     *
     * @param num
     * @return
     */
    static Map<Integer, Integer> primeFactor(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
                num /= i;
            }
        }
        return map;
    }

    /**
     * 输出分解的质因数
     *
     * @param map
     */
    static void printPrime(int num, Map<Integer, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (int k : map.keySet()) {
            int v = map.get(k);
            for (int i = 0; i < v; i++) {
                sb.append("*").append(k);
            }
        }
        System.out.println(num + "=" + sb.substring(1));
    }


}

