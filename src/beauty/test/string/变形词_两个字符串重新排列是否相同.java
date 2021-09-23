package beauty.test.string;

import java.util.Arrays;

/**
 * 功能描述：算法——变形词_两个字符串重新排列是否相同
 * 变形词：两个字符串字符与数量相同 abc，cba；abcd，cabd
 *  规定：大小写为不同字符，且考虑空格
 *
 * @author RenShiWei
 * Date: 2020/4/3 20:41
 **/
public class 变形词_两个字符串重新排列是否相同 {

    /**
     * 利用自带的API解题
     * 时间复杂度，排序n*logn
     * @param s1
     * @param s2
     * @return
     */
    static boolean checkSame(String s1,String s2){
        if (s1.length()!=s2.length()){
            return false;
        }
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }

    /*
        思路2：如果是字符串是ASCII码，定义256的数组，采用计数排序
        然后两个字符串各循环一次，一次加一次减，如果出现负数，立即返回

        最后在扫描数组，有大于0的返回false

        时间复杂度为  N
     */
}

