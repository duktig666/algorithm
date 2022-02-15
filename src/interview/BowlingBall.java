package interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 保龄球 算法 —— 创邻科技 笔试
 *
 * @author RenShiWei
 * Date: 2022/2/15
 **/
public class BowlingBall {

    /** 全中 */
    private final char ALL = 'X';
    /** 补中 */
    private final char FILL = '/';
    /** 未中 */
    private final char NOT = '-';

    public int bowling(char[] arr) {
        int res = 0;
        // 第几局
        int i = 1;
        // 待下次计算索引
        int index = 0;
        // 进行10次 投球
        while (i <= 9) {
            int[] scoreOnceArr = this.scoreOnce(arr, i, index);
            res += scoreOnceArr[0];
            // 重置索引
            index = scoreOnceArr[1];
            // 进行下一局计算
            i++;
        }

        // 单独计算第10次
        res += scoreTen(arr, index);

        return res;
    }

    /**
     * 第10轮分数
     */
    private int scoreTen(char[] arr, int index) {
        int sum = 0;
        /* 第10次投掷 */


        /*  第一次额外投掷（数字，全中，未中） */
        // 数字
        if (this.isNum(arr[index])) {
            sum += arr[index];
            // 第二次投掷（数字，补中,未中（不计算））
            if (this.isNum(arr[index + 1])) {
                sum += arr[index + 1];
            } else if (arr[index] == FILL) {
                // 补中，往后计算一次（数字，全中）
                if (this.isNum(arr[index + 2])) {
                    sum += arr[index + 2];
                } else if (arr[index] == ALL) {
                    sum += 10;
                }
            }
        } else if (arr[index] == ALL) {
            sum += 10;
            // 全中，再往后计算两次
            for (int i = 0; i < 2; i++) {
                if (this.isNum(arr[index + 1])) {
                    sum += arr[index + 1];
                } else if (arr[index] == ALL) {
                    sum += 10;
                }
            }
        } else if (arr[index] == NOT) {
            // 未中，再投一次
            // 第二次投掷（数字，补中,未中（不计算））
            if (this.isNum(arr[index + 1])) {
                sum += arr[index + 1];
            } else if (arr[index] == FILL) {
                // 补中，往后计算一次（数字，全中）
                if (this.isNum(arr[index + 2])) {
                    sum += arr[index + 2];
                } else if (arr[index] == ALL) {
                    sum += 10;
                }
            }
        }
        return sum;
    }

    /**
     * 计算第 i 轮分数
     * <p>
     * 每轮如果是 X(ALL)投一次，如果是其他投两次
     *
     * @param arr   数组
     * @param i     第 i 轮
     * @param index 第 i 轮 分数应该在的索引位置
     * @return 第 i 轮应该得的分数;下一次计算的索引
     */
    private int[] scoreOnce(char[] arr, int i, int index) {
        // 每一轮的分数
        int sum = 0;

        /* 计算第一次投掷 分数（第一次不可能是 补中） */
        if (this.isNum(arr[index])) {
            // 如果是数字分数
            sum += arr[index];

            /* 计算第二次投掷；可能情况：数字分数，补中，未中 */
            // 数字分数
            if (this.isNum(arr[index + 1])) {
                sum += arr[index + 1];
            } else if (arr[index + 1] == FILL) {
                // 补中 score = 0 + 10
                sum += (10 - arr[index]);
                // 计算补中奖励
                sum += this.fillReward(arr, i, index);
            }

            // 计算下一次应该计算的索引
            index += 2;

        } else {
            // 如果是非数字分数
            if (arr[index] == ALL) {
                // 如果是 全中；再往后计算两次
                // 计算本轮
                sum += 10;

                // 全中奖励分数
                sum += this.allReward(arr, i, index);

                // 计算下一次应该计算的索引，全中只投掷一次
                index += 1;

            } else if (arr[index] == NOT) {
                // 如果是未中，直接计算第二次投掷。可能情况：数字分数，未中（不处理），补中

                // 数字分数
                if (this.isNum(arr[index + 1])) {
                    sum += arr[index + 1];
                } else if (arr[index + 1] == FILL) {
                    // 补中 score = 0 + 10
                    sum += 10;
                    // 计算补中奖励
                    sum += this.fillReward(arr, i, index);
                }

                // 计算下一次应该计算的索引
                index += 2;

            }
        }

        // 第10次特殊处理

        return new int[] {sum, index};
    }

    /**
     * 计算补中的奖励分数
     * <p>
     * 第10次 特殊处理 todo
     */
    private int fillReward(char[] arr, int i, int index) {
        int sum = 0;
        /* 计算 奖励分数 */
        // 计算后边第一次（不可能是FILL）
        if (this.isNum(arr[index + 1])) {
            // 如果是数字直接加，NOT不用管
            sum += arr[index + 1];
        } else if (arr[index + 1] == ALL) {
            sum += 10;
        }
        return sum;
    }

    /**
     * 计算全中的奖励分数
     * <p>
     */
    private int allReward(char[] arr, int i, int index) {
        int sum = 0;
        /* 计算 奖励分数 */
        // 计算后边第一次（不可能是FILL）
        if (this.isNum(arr[index + 1])) {
            // 如果是数字直接加，NOT不用管
            sum += arr[index + 1];
        } else if (arr[index + 1] == ALL) {
            sum += 10;
        }

        // 计算后边第二次（几种情况都有可能）
        if (this.isNum(arr[index + 2])) {
            // 如果是数字直接加，NOT不用管
            sum += arr[index + 2];
        } else if (arr[index + 2] == ALL) {
            sum += 10;
        } else if (arr[index + 2] == FILL) {
            // index + 1 = index + 2 - 1
            sum += 10 - arr[index + 1];
        }
        return sum;
    }

    /**
     * 每轮分数判断
     *
     * @return 是否为数字分数
     */
    private boolean isNum(char score) {
        // 1~9 ASCII
        return score >= 49 && score <= 57;
    }

    /**
     * 测试用例1： XXXXXXXXXXXX
     * <p>
     * 通过
     */
    @Test
    public void test1() {
        String s = "XXXXXXXXXXXX";
        assert testHelp(s) == 300;
    }

    /**
     * 测试用例2： --------------------
     * <p>
     * 通过
     */
    @Test
    public void test2() {
        String s = "--------------------";
        assert testHelp(s) == 0;
    }

    /**
     * 测试用例3： 9/9/9/9/9/9/9/9/9/9/9
     * <p>
     * 未通过
     */
    @Test
    public void test3() {
        String s = "9/9/9/9/9/9/9/9/9/9/9";
        assert testHelp(s) == 190;
    }

    /**
     * 测试用例4： 12345432123454321234
     * <p>
     * 未通过
     */
    @Test
    public void test4() {
        String s = "12345432123454321234";
        assert testHelp(s) == 58;
    }

    /**
     * 测试用例5： X72X9/7-9/XX9/9-
     * <p>
     * 未通过
     */
    @Test
    public void test5() {
        String s = "X72X9/7-9/XX9/9-";
        assert testHelp(s) == 169;
    }

    /**
     * 测试用例5： X72X9/7-9/XX9/9-
     * <p>
     * 未通过
     */
    @Test
    public void test6() {
        String s = "X7/368-XX8/637/9/X";
        assert testHelp(s) == 162;
    }

    private int testHelp(String s) {
        List<Character> input = new ArrayList<>();
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        BowlingBall bowlingBall = new BowlingBall();
        int res = bowlingBall.bowling(arr);
        System.out.println(res);
        return res;
    }
    
}

