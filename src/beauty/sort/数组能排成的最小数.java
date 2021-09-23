package beauty.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 功能描述：数组能排成的最小数(特殊排序)
 * ➢输入-一个正整数数组,把数组里所有整数拼接起来排成一个数,打
 * 印出能拼接出的所有数字中最小的一个。
 * 例如输入数组{3,32,321} ,则打印出这3个数字能排成的最小数字
 * 为: 321323
 *
 * @author RenShiWei
 * Date: 2020/3/30 21:51
 **/
public class 数组能排成的最小数 {

    static int findMin ( Integer[] arr ) {
        //自定义比较规则
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare ( Integer o1, Integer o2 ) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main ( String[] args ) {
        System.out.println(findMin(new Integer[]{3,32,321}));
    }
}

