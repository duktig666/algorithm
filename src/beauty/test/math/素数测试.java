package beauty.test.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：算法——n是不是素数
 * -2~n-1间是否有整数能整除n?
 * -如果d是n的约数,那么n/d也是n的约数,由n = d★(n/d) 可知,d<=根
 * 号n,所以检查2~根号n之间是否有整数能整险n
 *
 * @author RenShiWei
 * Date: 2020/4/11 16:32
 **/
public class 素数测试 {

    /**
     * 测试n是否为素数
     *
     * @param num
     * @return
     */
    public static boolean isPrime ( long num ) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 质因数分解 8=2*2*2
     * @param num
     * @return
     */
    public static Map<Integer, Integer> primeFactor ( int num ) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                Integer v = map.get(i);
                if (v == null) {
                    map.put(i, 1);
                } else {
                    map.put(i, v + 1);
                }
                num /= i;
            }
        }
        return map;
    }

    public static void main ( String[] args ) {
        Map<Integer, Integer> map = primeFactor(6);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            for (int i = 0; i < v; i++) {
                sb.append("*").append(k);
            }
        }
        System.out.println(sb.substring(1));
        System.out.println(map);
    }

}

