package beauty.location;

/**
 * 功能描述：算法——颠倒给定的 32 位无符号整数的二进制位
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p>
 * 示例 2：
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *       因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * <p>
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 * <p>
 * 思路1：暴力破解。int转Sting，翻转，在转会int
 * <p>
 * 思路2：位运算。
 * 1.循环遍历31次
 * 取出最后一位，并记录  n&1
 * n<<1
 * 2.最终 StringBuilder记录结果
 * 缺点：无论数有怎样的特点，都要循环31次，效率低
 * <p>
 * 思路3：位运算。
 *
 * @author RenShiWei
 * Date: 2020/3/5 21:33
 **/
public class LeetCode_颠倒二进制位 {

    /**
     * 系统自带int翻转方法
     */
    public static int reverseBits(int n) {
        return Integer.reverse(n);
    }

    /**
     * 前进方法
     */
    public static int reverseBits2(int n) {
        int m = 0, i = 32;
        while (i > 0) {
            //m左移1位，记录n最后一位
            m = m << 1;
            //取n最后一位
            m += n & 1;
            //n舍弃最后一位
            n = n >> 1;
            i--;
        }
        return m;
    }

    /**
     * 最后一位移到首位，移动位数每次-1
     *
     * @param n
     * @return
     */
    public int reverseBits3(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

    /**
     * LeetCode不能通过，原因——测试用例大于了int的范围
     */
    public static int reverseBits4(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            result.append(n & 1);
            n = n >> 1;
        }
        return Integer.parseInt(result.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits4(43261596));
    }

}

