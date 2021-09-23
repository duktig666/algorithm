package beauty.serven;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述：算法——合法括号
 * 实现一种算法，打印n对括号的全部有效组合( 即左右括号正确配对)。
 * 示例
 * 输人: 3
 * 输出: ((())), (()()), (())(),()(()),()()()
 *
 * @author RenShiWei
 * Date: 2020/5/4 16:05
 **/
public class 合法括号 {

    public static void main ( String[] args ) {
        System.out.println(solve(3));
        System.out.println(solve2(3));
    }

    /**
     * 递归方式解决
     *
     * @param n
     * @return
     */
    static Set<String> solve ( int n ) {
        Set<String> sN = new HashSet<>();
        if (n == 1) {
            sN.add("()");
            return sN;
        }
        Set<String> sN1 = solve(n - 1);
        for (String s : sN1) {
            sN.add("()" + s);
            sN.add(s + "()");
            sN.add("(" + s + ")");
        }
        return sN;
    }

    /**
     * 迭代方式解决
     *
     * @param n
     * @return
     */
    static Set<String> solve2 ( int n ) {
        Set<String> res = new HashSet<>();
        res.add("()");
        if (n == 1) {
            return res;
        }
        for (int i = 2; i <= n; i++) {
            Set<String> set = new HashSet<>();
            for (String s : res) {
                set.add("()" + s);
                set.add(s + "()");
                set.add("(" + s + ")");
            }
            res = set;
        }
        return res;
    }

}

