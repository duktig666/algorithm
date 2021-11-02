package offer;

/**
 * description:剑指Offer17——打印从1到最大的n位数 @see https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author RenShiWei
 * Date: 2021/11/2 14:08
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class Print1ToMaxOfNDigits17 {

    /**
     * 把问题转成数字排列的解法
     * 相当于回溯法
     *
     * @param n n位的数
     */
    public void printNumbers(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigitsRecursively(number, n, 0);
    }

    /**
     * 递归核心
     *
     * @param number 当前数字
     * @param length 打印位数
     * @param index  字符串的第几位
     */
    private void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index > length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    /**
     * 根据字符串打印出数字
     *
     * @param number 打印位数
     */
    private void printNumber(char[] number) {
        // 默认字符串不以0开始
        boolean isBegining0 = true;

        for (int i = 0; i < number.length; i++) {
            if (isBegining0 && number[i] != '0') {
                isBegining0 = false;
            }
            if (! isBegining0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

}

