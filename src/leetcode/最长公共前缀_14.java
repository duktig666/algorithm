package leetcode;

/**
 * 功能描述：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author RenShiWei
 * Date: 2020/4/6 17:05
 **/
public class 最长公共前缀_14 {

    public static String longestCommonPrefix ( String[] strs ) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 0; i < strs.length; i++) {
            s=compareStr(s,strs[i]);
        }
        return s;
    }

    static String compareStr ( String s1, String s2 ) {
        StringBuilder sb=new StringBuilder();
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static void main ( String[] args ) {
        String[] strings1 = {"flower", "flow", "flight"};
        String[] strings2 = {"dog", "racecar", "car"};
        String[] strings3 = {};
        String[] strings4 = {"c", "c"};
        System.out.println(longestCommonPrefix(strings1));
        System.out.println(longestCommonPrefix(strings2));
        System.out.println(longestCommonPrefix(strings3));
        System.out.println(longestCommonPrefix(strings4));
    }

}

