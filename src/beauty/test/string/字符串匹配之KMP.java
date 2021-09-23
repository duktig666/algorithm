package beauty.test.string;

/**
 * 功能描述：算法——字符串匹配之KMP
 *
 * @author RenShiWei
 * Date: 2020/4/6 16:12
 **/
public class 字符串匹配之KMP {

    /**
     * 暴力破解
     * 依次从每一个字符开始匹配
     * @param s 待匹配字符串
     * @param p 键
     * @return 匹配的起点索引
     */
    static int indexOf ( String s, String p ) {
        int i = 0;
        //扫描起点，以i为起点
        int sc = i;
        //键扫描指针
        int j = 0;
        while (sc < s.length()) {
            if (s.charAt(sc) == p.charAt(j)) {
                //有匹配到的字符
                sc++;
                j++;
                if (j == p.length()) {
                    return i;
                }
            } else {
                //若匹配不到
                //以下一个字母为起点
                i++;
                sc = i;
                j = 0;
            }
        }
        return -1;
    }

}


