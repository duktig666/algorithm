package beauty.sort;

import java.util.Arrays;

/**
 * 功能描述：算法-数组的包含
 * ➢输入两个字符串str1和str2 ,请判断str1中的所有字符是否都存在与str2中
 *
 * @author RenShiWei
 * Date: 2020/3/30 22:03
 **/
public class 数组的包含 {

    static boolean check1 ( String s1, String s2 ) {
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
//            if (s2.indexOf(a) == -1) {
//                return false;
//            }
            int index=Arrays.binarySearch(s2Arr,a);
            if (index<0){
                return false;
            }
        }
        return true;
    }


}

