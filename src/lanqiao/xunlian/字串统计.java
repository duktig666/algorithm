package lanqiao.xunlian;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/6/4 15:36
 **/
public class 字串统计 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        String s = sc.next();
        //定义map临时存储
        Map<String, Integer> map = new HashMap<>();
        //保存字符串的出现次数的最大值
        int maxValue = 0;
        //保存出现次数最多的字符串
        String maxKey = "";
        for (int j = l; j < s.length(); j++) {
            for (int i = 0; i + j < s.length(); i++) {
                //字符串截取
                String str = s.substring(i, i + j);
                if (map.containsKey(str)) {
                    int value = map.get(str);
                    map.put(str, value + 1);
                    //处理记录出现次数最多，并且最长的字符串
                    //次数最多
                    if (value > maxValue) {
                        maxValue = value;
                        maxKey = str;
                    } else if (value == maxValue) {
                        //字符串最长
                        if (str.length() > maxKey.length()) {
                            maxKey = str;
                        }
                    }
                } else {
                    map.put(str, 1);
                }
            }
        }
        System.out.println(maxKey);
    }

}

