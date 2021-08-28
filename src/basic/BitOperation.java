package basic;

/**
 * description:位运算
 *
 * @author RenShiWei
 * Date: 2021/8/28 21:26
 **/
public class BitOperation {

    //---------------位运算实现加减乘除------------------

    /**
     * 递归实现加法
     */
    public static int add(int a, int b) {
        if (b == 0) {
            // 这里 b 代表进位情况，为0时说明这次没有进位，结束递归
            return a;
        }
        //进位计算。 & 两位都为1，否则为0 , 再左移一位（ 1101 & 1001 = 1001; 01001 << 1 = 10010 ） 刚好相当于进位
        int carry = (a & b) << 1;
        //不进位加法。 ^ 相同为0，不同为1（1 ^ 1 = 0; 0 ^ 0 = 0; 1 ^ 0 = 1) 刚好满足需求 。
        a = a ^ b;
        return add(a, carry);
    }

    /**
     * 循环实现加法
     */
    int addLoop(int a, int b) {
        int carry;
        while (b != 0) {
            //进位
            carry = (a & b) << 1;
            //不进位加法
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    /**
     * 减法实现
     * a - b = a + (-b) 即将b转为二进制的负数形式 然后执行加法操作即可（调用上边两个加法任意一个即可）
     * 负数 = 正数取反 + 1
     * <p>
     * 反码 = 正数取反； 补码 = 反码 +1 = 正数取反 + 1
     */
    public static int subtraction(int a, int b) {
        //b由正数转为负数（取反 + 1；补码）
        b = add(~ b, 1);
        return add(a, b);
    }

    /**
     * 乘法（乘积计算，推荐方式）
     *
     * @param a 被乘数
     * @param b 乘数
     * @return 两数乘积
     */
    public static int multiplication(int a, int b) {
        //将乘数和被乘数都取绝对值　
        //被乘数
        int multiplicand = a < 0 ? add(~ a, 1) : a;
        //乘数
        int multiplier = b < 0 ? add(~ b, 1) : b;

        //计算绝对值的乘积　　
        int res = 0;
        while (multiplier > 0) {
            // 每次考察乘数的最后一位　　
            if ((multiplier & 0x1) > 0) {
                res = add(res, multiplicand);
            }
            // 每运算一次，被乘数要左移一位　　　　
            multiplicand = multiplicand << 1;
            // 每运算一次，乘数要右移一位（可对照上图理解）
            multiplier = multiplier >> 1;
        }
        //计算乘积的符号　　
        if ((a ^ b) < 0) {
            res = add(~ res, 1);
        }
        return res;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println("----------位运算实现加减乘除------------");
        System.out.println("----------递归加法测试-----------");
        System.out.println("3 + 9 = " + add(3, 9));
        System.out.println("-3 + 9 = " + add(- 3, 9));
        System.out.println("----------减法实现--------------");
        System.out.println("3 - 9 = " + subtraction(3, 9));
        System.out.println("3 - (-9) = " + subtraction(3, - 9));
    }


}

