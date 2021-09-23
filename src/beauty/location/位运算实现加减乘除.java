package beauty.location;

/**
 * 功能描述：算法——位运算实现加减乘除
 *
 * @author RenShiWei
 * Date: 2020/3/5 16:17
 **/
public class 位运算实现加减乘除 {

    /**
     * 功能描述：递归形式实现加法
     * @author RenShiWei
     * Date: 2020/3/5 16:20
     */
    static int add(int a ,int b) {
        if (b == 0) {
            return a;
        } else {
            int carry = (a & b) << 1;
            a = a ^ b;
            return add(a, carry);
        }
    }

    /**
     * 功能描述：非递归形式实现加法
     * @author RenShiWei
     * Date: 2020/3/5 16:20
     */
    static int add2(int a ,int b){
        int carry;
        while (b != 0){
            //进位
            carry = (a & b) << 1;
            //不进位加法
            a = a ^b;
            b = carry;
        }
        return a;
    }

    /**
     * 功能描述：减法（加上一个负数，负数=正数取反+1）
     * @author RenShiWei
     * Date: 2020/3/5 16:20
     */
    static int subtraction(int a ,int b){
        b = add(~b,1);
        return add(a,b);
    }

    /**
     * 功能描述：乘法（推荐）
     *  考虑符号问题
     * @param a 被乘数
     * @param b 乘数
     * @return 乘法结果
     * @author RenShiWei
     * Date: 2020/3/5 17:18
     */
    static int multiplication(int a,int b){
        //将乘数和被乘数都取绝对值　
        int multiplicand = a < 0 ? add(~a, 1) : a;
        int multiplier = b < 0 ? add(~b , 1) : b;

        //计算绝对值的乘积　　
        int product = 0;
        while(multiplier > 0) {
            // 每次考察乘数的最后一位　　
            if((multiplier & 0x1) > 0) {
                product = add(product, multiplicand);
            }
            // 每运算一次，被乘数要左移一位　　　　
            multiplicand = multiplicand << 1;
            // 每运算一次，乘数要右移一位（可对照上图理解）
            multiplier = multiplier >> 1;
        }
        //计算乘积的符号　　
        if((a ^ b) < 0) {
            product = add(~product, 1);
        }
        return product;
    }

    /**
     * 功能描述：乘法（利用加法实现）
     * @param a 被乘数
     * @param b 乘数
     * @return 乘法结果
     * @author RenShiWei
     * Date: 2020/3/5 17:18
     */
    static int multiplication2(int a,int b){
        // 取绝对值，如果为负则取反加一得其补码，即正数　　
        int multiplicand = a < 0 ? add(~a, 1) : a;
        int multiplier = b < 0 ? add(~b , 1) : b;
        // 计算绝对值的乘积　　
        int product = 0;
        int count = 0;
        while(count < multiplier) {
            product = add(product, multiplicand);
            // 这里可别用count++，都说了这里是位运算实现加法
            count = add(count, 1);
        }
        // 确定乘积的符号　　
        // 只考虑最高位，如果a,b异号，则异或后最高位为1；如果同号，则异或后最高位为0；
        if((a ^ b) < 0) {
            product = add(~product, 1);
        }
        return product;
    }


    /**
     * 功能描述：除法（减法实现）
     * @author RenShiWei
     * Date: 2020/3/5 17:30
     */
    static int division(int a,int b){
        // 先取被除数和除数的绝对值
        int dividend = a > 0 ? a : add(~a, 1);
        int divisor = b > 0 ? a : add(~b, 1);
        // 商
        int quotient = 0;
        // 余数
        int remainder = 0;
        // 不断用除数去减被除数，直到被除数小于被除数（即除不尽了）
        // 直到商小于被除数
        while(dividend >= divisor){
            dividend = subtraction(dividend, divisor);
            quotient = add(quotient, 1);
        }
        // 确定商的符号
        // 如果除数和被除数异号，则商为负数
        if((a ^ b) < 0){
            quotient = add(~quotient, 1);
        }
        // 确定余数符号
        remainder = b > 0 ? dividend : add(~dividend, 1);
        // 返回商
        return quotient;
    }

    /**
     * 功能描述：除法（推荐）
     * @author RenShiWei
     * Date: 2020/3/5 17:30
     */
    static int division2(int a,int b){
        // 先取被除数和除数的绝对值
        int dividend = a > 0 ? a : add(~a, 1);
        int divisor = b > 0 ? a : add(~b, 1);
        // 商
        int quotient = 0;
        // 余数
        int remainder = 0;
        for(int i = 31; i >= 0; i--) {
            //比较dividend是否大于divisor的(1<<i)次方，不要将dividend与(divisor<<i)比较，而是用(dividend>>i)与divisor比较，
            //效果一样，但是可以避免因(divisor<<i)操作可能导致的溢出，如果溢出则会可能dividend本身小于divisor，但是溢出导致dividend大于divisor
            if((dividend >> i) >= divisor) {
                quotient = add(quotient, 1 << i);
                dividend = subtraction(dividend, divisor << i);
            }
        }
        // 确定商的符号
        if((a ^ b) < 0){
            // 如果除数和被除数异号，则商为负数
            quotient = add(~quotient, 1);
        }
        // 确定余数符号
        remainder = b > 0 ? dividend : add(~dividend, 1);
        // 返回商
        return quotient;
    }



    public static void main ( String[] args ) {
        System.out.println(add(6,3));
        System.out.println(add2(6,3));
        System.out.println(subtraction(6,3));
        System.out.println(multiplication(6,-3));
        System.out.println(multiplication2(6,-3));
        System.out.println(division(6,-3));
        System.out.println(division2(6,-3));
    }
}

