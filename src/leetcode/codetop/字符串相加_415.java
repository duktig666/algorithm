package leetcode.codetop;

/**
 * description:https://leetcode-cn.com/problems/add-strings/
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * @author RenShiWei
 * Date: 2021/12/23 20:36
 **/
public class 字符串相加_415 {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        // 表示进位
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            // 短的字符串补0
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            // 取余计算结果
            ans.append(result % 10);
            // 计算进位（到下一次计算）
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

}

