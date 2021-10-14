package offer;

/**
 * description: 剑指offer16题——数值的整数次方
 * <p>
 * 实现函数double power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * @author RenShiWei
 * Date: 2021/10/14 9:39
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class Power16 {

    /**
     * 计算数值的整数次方
     */
    public double power(double base, int exponent) {
        // 0的0次方没有意义，返回 0 或者 1 都可
        if (base == 0 && exponent < 0) {
            throw new IllegalArgumentException("０的负数次幂无意义");
        }

        // 任何数的0次方，结果都为1
        if (exponent == 0) {
            return 1.0;
        } else if (exponent == 1) {
            // 任何数的1次方，都为本身
            return base;
        }

        // 结果是否要变为负数 原来的数是负数，而且指数为单数时，结果为负数
        // 判断奇偶数： (exponent & 0x1) == 1  相当于  exponent % 2 != 0
        boolean isAbsRes = base < 0 && (exponent & 0x1) == 1;

        // 指数取绝对值
        int absExponent = Math.abs(exponent);

        double result = powerWithPositiveExponent(base, absExponent);
        // 如果指数为负数，结果为其 倒数
        if (exponent < 0) {
            result = 1.0 / result;
        }

        return result;
    }

    /**
     * 指数为正时，得到的整数次方
     * <p>
     * while循环为如下操作的优化：
     * for (int i = 1; i <= exponent; i++) {
     * result = result * base;
     * }
     */
    private double powerWithPositiveExponent(double base, int exponent) {
        double result = 1.0;
        double factor = base;
        while (exponent != 0) {
            if (exponent % 2 == 1) {
                result *= factor;
            }
            factor *= factor;
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Power16 test = new Power16();
        System.out.println(test.power(3, 2));
        System.out.println(test.power(- 3, 2));
        System.out.println(test.power(3, - 2));
        System.out.println(test.power(- 3, - 2));
        System.out.println(test.power(- 3, 3));
        System.out.println(test.power(2.10000, 3));
        System.out.println(test.power(- 2, 2));
        System.out.println(test.power(- 2, 3));
        System.out.println(test.power(0, - 2));
    }

    /**
     * 超时考虑使用如下方法
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = - b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

}

