package offer;

import org.junit.Test;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/5 18:05
 **/
public class ReplaceBlank_5 {

    /**
     * 使用StringBuilder或StringBuffer解决
     */
    String solveByStringBuilderOrBuffer(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 使用replace方法
     * String的replace只能替换字符，但是StringBuffer/StringBuilder可以替换字符串
     * <br>
     * 这个方法感觉还不如上边的
     */
    String solveByReplace(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input);
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                int index = i + sum * 2;
                sb.replace(index, index + 1, "%20");
                sum++;
            }
        }
        return sb.toString();
    }

    /**
     * 不使用默认提供的api，使用数组来实现
     * 从后往前复制，双指针法。因为java中对原数组并不可知原数组之后是无限空间，所有只能新建一个数组用来模拟
     */
    String solveByCopy(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sum++;
            }
        }
        if (sum == 0) {
            return null;
        }
        int len = input.length(), charsLen = input.length() + sum * 2, index = charsLen - 1;
        char[] chars = new char[charsLen];
        for (int i = len - 1; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = input.charAt(i);
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        String s = "We Are Happy";
        System.out.println(solveByStringBuilderOrBuffer(s));
        System.out.println(solveByReplace(s));
        System.out.println(solveByCopy(s));
    }

}

