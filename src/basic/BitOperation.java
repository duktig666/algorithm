package basic;

/**
 * description:位运算
 *
 * @author RenShiWei
 * Date: 2020/3/5 16:17
 **/
public class BitOperation {

    //---------------位运算实现加减乘除------------------

    /**
     * 循环实现加法
     */
    public static int add(int a, int b) {
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
     * 递归实现加法
     */
    private static int addRecursion(int a, int b) {
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
        //将乘数和被乘数都取绝对值 （负数->正数，补码：取反+1）　
        //被乘数
        int multiplicand = a < 0 ? add(~ a, 1) : a;
        //乘数
        int multiplier = b < 0 ? add(~ b, 1) : b;

        //计算绝对值的乘积　　
        int res = 0;
        while (multiplier > 0) {
            // 每次考察乘数的最后一位， n & 0x1 代表，取n的最后一位　
            if ((multiplier & 0x1) > 0) {
                res = add(res, multiplicand);
            }
            // 每运算一次，被乘数要左移一位　　　　
            multiplicand = multiplicand << 1;
            // 每运算一次，乘数要右移一位
            multiplier = multiplier >> 1;
        }

        //计算乘积的符号（只有一正一负，才会小于0）　　
        if ((a ^ b) < 0) {
            // 将结果变为负数
            res = add(~ res, 1);
        }
        return res;
    }

    /**
     * 乘法（累加实现，不推荐）
     *
     * @param a 被乘数
     * @param b 乘数
     * @return 两数乘积
     */
    private static int multiplicationByAdd(int a, int b) {
        //被乘数
        int multiplicand = a < 0 ? add(~ a, 1) : a;
        //乘数
        int multiplier = b < 0 ? add(~ b, 1) : b;
        // 计算绝对值的乘积　　
        int res = 0;
        // 计算相加的次数，要小于被乘数
        int count = 0;
        while (count < multiplier) {
            res = add(res, multiplicand);
            // 这里可别用count++，都说了这里是位运算实现加法
            count = add(count, 1);
        }
        // 确定乘积的符号　　
        // 只考虑最高位，如果a,b异号，则异或后最高位为1；如果同号，则异或后最高位为0；
        if ((a ^ b) < 0) {
            res = add(~ res, 1);
        }
        return res;
    }

    /**
     * 除法（增大步长累减，推荐）
     * <p>
     * 所有的int型数据都可以用[2 ^ 0, 2 ^ 1,…,2 ^ 31]这样一组基来表示（int型最高31位）。不难想到用除数的[2 ^ 31,2 ^ 30,…,2 ^ 2,2 ^ 1,2 ^0]倍
     * 尝试去减被除数，如果减得动，则把相应的倍数加到商中；如果减不动，则依次尝试更小的倍数。这样就可以快速逼近最终的结果。
     * <p>
     * 2的i次方其实就相当于左移i位，因为int型数据最大值就是2^31,所以从31位开始
     *
     * @param a 被除数
     * @param b 除数
     * @return a / b
     */
    public static int division(int a, int b) {
        // 先取被除数和除数的绝对值
        //被除数
        int dividend = a > 0 ? a : add(~ a, 1);
        // 除数
        int divisor = b > 0 ? b : add(~ b, 1);
        // 商
        int quotient = 0;
        // 余数
        int remainder = 0;
        for (int i = 31; i >= 0; i--) {
            /*
              比较dividend是否大于divisor的(1<<i)次方，不要将dividend与(divisor<<i)比较，而是用(dividend>>i)与divisor比较，
              效果一样，但是可以避免因(divisor<<i)操作可能导致的溢出，如果溢出则会可能dividend本身小于divisor，但是溢出导致dividend大于divisor
             */
            if ((dividend >> i) >= divisor) {
                quotient = add(quotient, 1 << i);
                dividend = subtraction(dividend, divisor << i);
            }
        }
        // 确定商的符号
        if ((a ^ b) < 0) {
            // 如果除数和被除数异号，则商为负数
            quotient = add(~ quotient, 1);
        }
        // 确定余数符号
        remainder = b > 0 ? dividend : add(~ dividend, 1);
        // 返回商
        return quotient;
    }

    /**
     * 除法（累减实现）
     *
     * @param a 被除数
     * @param b 除数
     * @return a / b
     */
    private static int division2(int a, int b) {
        // 先取被除数和除数的绝对值
        //被除数
        int dividend = a > 0 ? a : add(~ a, 1);
        // 除数
        int divisor = b > 0 ? b : add(~ b, 1);
        // 商
        int quotient = 0;
        // 余数
        int remainder = 0;
        // 不断用除数去减被除数，直到被除数小于被除数（即除不尽了）
        while (dividend >= divisor) {
            dividend = subtraction(dividend, divisor);
            // 相除一次，商加 1
            quotient = add(quotient, 1);
        }
        // 确定商的符号，如果除数和被除数异号，则商为负数
        if ((a ^ b) < 0) {
            quotient = add(~ quotient, 1);
        }
        // 确定余数符号
        remainder = b > 0 ? dividend : add(~ dividend, 1);
        // 返回商
        return quotient;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println("----------位运算实现加减乘除------------");
        System.out.println("----------加法测试-----------");
        System.out.println("3 + 9 = " + add(3, 9));
        System.out.println("-3 + 9 = " + add(- 3, 9));
        System.out.println("----------减法测试--------------");
        System.out.println("3 - 9 = " + subtraction(3, 9));
        System.out.println("3 - (-9) = " + subtraction(3, - 9));
        System.out.println("----------乘法测试--------------");
        System.out.println("3 * 9 = " + multiplication(3, 9));
        System.out.println("3 * (-9) = " + multiplication(3, - 9));
        System.out.println("-3 * 9 = " + multiplication(- 3, 9));
        System.out.println("-3 * (-9) = " + multiplication(- 3, - 9));
        System.out.println("----------除法测试--------------");
        System.out.println("6 / 3 = " + division(6, 3));
        System.out.println("6 / (-3) = " + division(6, - 3));
        System.out.println("-6 / 3 = " + division(- 6, 3));
        System.out.println("-6 / (-3) = " + division(- 6, - 3));
        System.out.println("  ---  ");
        System.out.println("6 / 3 = " + division2(6, 3));
        System.out.println("6 / (-3) = " + division2(6, - 3));
        System.out.println("-6 / 3 = " + division2(- 6, 3));
        System.out.println("-6 / (-3) = " + division2(- 6, - 3));
    }


}

