package beauty.test.string;

/**
 * 功能描述：算法——字符串匹配之PabinKarp
 * <p>
 * 一个字符串中，找出是否匹配另一个短字符串（连续的字符串）
 *
 * @author RenShiWei
 * Date: 2020/4/6 14:43
 **/
public class 字符串匹配之PabinKarp {

    final static long seed = 31;

    /**
     * 采用31进制计算字符串的hash值
     * c0*31^2+c1*31^1+c2*31^0 ——> ((0+c0)*31+c1)*31+c2
     *
     * @param str
     * @return
     */
    static long hash(String str) {
        long hash = 0;
        for (int i = 0; i != str.length(); ++ i) {
            hash = seed * hash + str.charAt(i);
        }
        return hash % Long.MAX_VALUE;
    }

    /**
     * 计算待匹配的字符串的hash值
     * 将符合模式长度的源串依次计算hash值
     * 然后对比
     * <p>
     * 并没有降低时间复杂度
     *
     * @param p 待匹配的字符串（模式）
     * @param s 源串
     */
    static void match(String p, String s) {
        //p的hash值
        long hash_p = hash(p);
//        int p_len = p.length();
//        for (int i = 0; i < p_len; i++) {
//            long hash_i = hash(s.substring(i, i + p_len));
//            if (hash_i == hash_p) {
//                System.out.println("match：" + i);
//            }
//        }
        long[] hashOfs = hash(s, p.length());
        match(hash_p, hashOfs);
    }

    /**
     * 滚动hash
     * 用滚动方法求出s中长度为n的每个子串的hash，组成一个hash数组
     *
     * @param s 源串
     * @param n 子串的长度
     * @return
     */
    static long[] hash(final String s, final int n) {
        long[] res = new long[s.length() - n - 1];
        //前n个字符的hash
        res[0] = hash(s.substring(0, n));
        for (int i = n; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - n);
            //前n个字符的hash*seed-前n个字符的第一个字符*seed的n次方
            long v = (res[i - n] * seed + newChar - NExponent.ex2(seed, n) * oldChar) % Long.MAX_VALUE;
            res[i - n + 1] = v;
        }
        return res;
    }

    static void match(long hash_p, long[] hash_s) {
        for (int i = 0; i < hash_s.length; i++) {
            if (hash_s[i] == hash_p) {
                System.out.println("match：" + i);
            }
        }
    }


}

