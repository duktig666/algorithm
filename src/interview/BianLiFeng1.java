package interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * description:
 * <p>
 * 便利蜂每个货架上的商品都有唯一编号(不要求连续)，当多个货架的商品出现调换的时候，会出现编号重复的情况
 * 现给定一组商品编号，每次操作将会选择任意一个商品，使其编号+ 1
 * 返回使这组商品编号可以放到一个货架上的最少操作次数。要求时间复杂度低于O(N方)
 * <p>
 * input: 3,2,1,2,1,7
 * output: 6
 *
 * @author RenShiWei
 * Date: 2021/11/24 19:39
 **/
public class BianLiFeng1 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).next();
        String[] arr = input.split(",");
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (String s : arr) {
            int num = Integer.parseInt(s);
            while (! set.add(num)) {
                num++;
                res++;
            }
        }
        System.out.println(res);
    }


}

