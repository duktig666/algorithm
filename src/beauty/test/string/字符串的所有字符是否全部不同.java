package beauty.test.string;

/**
 * 功能描述：算法——字符串的所有字符是否全部不同
 *
 * 最好确定字符串是ASCII码，还是Unicode码
 *
 * 如果不使用额外数据结构如何解题？
 *  -每一个字符循环查找之后还有没有出现
 *
 * @author RenShiWei
 * Date: 2020/4/3 20:25
 **/
public class 字符串的所有字符是否全部不同 {

    /**
     * 借助数组实现
     * 而且字符串是ASCII码
     * @param str
     * @return
     */
    static boolean checkDifferent(String str){
        if ("".equals(str)){
            return true;
        }
        int[] flag=new int[128];
        //扫描字符串
        for (int i = 0; i < str.length(); i++) {
            int c=str.charAt(i);
            if (flag[c]>0){
                return false;
            }else {
                flag[c]++;
            }
        }
        return true;
    }



}

