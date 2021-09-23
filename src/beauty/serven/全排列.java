package beauty.serven;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/5/5 16:55
 **/
public class 全排列 {

    /**
     * 迭代解决
     *
     * @param s
     * @return
     */
    public ArrayList<String> solve1 ( String s ) {
        int n = s.length();
        ArrayList<String> res = new ArrayList<>();
        //初始化，包含第一个字符
        res.add(s.charAt(0) + "");

        for (int i = 1; i < n; i++) {
            ArrayList<String> newRes = new ArrayList<>();
            //新字符
            char c = s.charAt(i);
            for (String str : res) {
                //处理上一趟集合的字符
                //插入到每一个位置形成新的字符串
                //加在最前面
                String newStr = c + str;
                newRes.add(newStr);
                //加在最后面
                newStr = str + c;
                newRes.add(newStr);
                //加在每个字符中间
                for (int j = 1; j < str.length(); j++) {
                    newStr = str.substring(0, j) + c + str.substring(j);
                    newRes.add(newStr);
                }
            }
            res = newRes;
        }
        return res;
    }

    /**
     * 回溯解题
     * <p>
     * 不一定能维持排序
     *
     * @param s
     * @return
     */
    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> solve2 ( String s ) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        solve2(arr, 0);
        return result;
    }

    private void solve2 ( char[] arr, int k ) {
        //搞定了一个分支
        if (k == arr.length) {
            result.add(new String(arr));
        }
        //从k位开始的每个字符，都尝试放在新排列的k的位置
        for (int i = k; i < arr.length; i++) {
            //把后面的每个字符都放在k的位置上
            swap(arr, k, i);
            //递归
            solve2(arr, k + 1);
            //回溯
            swap(arr, k, i);
        }
    }

    void swap ( char[] arr, int i, int j ) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 前缀法
     */
    final static int k = 3;
    static int count = 0;

    public static void solve3 ( String prefix, char[] arr ) {
        if (prefix.length() == arr.length) {
            count++;
            if (count == k) {
                System.out.println("--------:" + prefix);
                System.exit(0);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            //这个字符可用：在prefix中出现的次数<在字符集中的出现次数
//            if (count(prefix, ch) < count(arr, ch)) {
                solve3(prefix + ch, arr);
//           }
        }
    }

}

