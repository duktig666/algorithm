package beauty.test.string;

import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述：算法——回文串
 *
 *  正着看，反着看都一样
 * @author RenShiWei
 * Date: 2020/4/4 17:38
 **/
public class 回文串 {

    /**
     * 翻转直接对比
     */
    static boolean idPalindrome(String str){
        if (StringUtils.isEmpty(str)){
            return true;
        }
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    /**
     * 输出四位的回文数组，从小到大
     */
    static void printStr(){
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i*1000+j*100+j*10+i);
            }
        }
    }

    public static void main ( String[] args ) {
        printStr();
    }
}

