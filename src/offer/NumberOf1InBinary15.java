package offer;

/**
 * description:剑指offer15题——二进制中1的个数 @see https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * @author RenShiWei
 * Date: 2021/9/22 21:38
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class NumberOf1InBinary15 {

    /**
     * 最优思路：
     * 1. 最后一位是0，减1后，最后一位变成0，其他不变
     * 2. 最后一位不是0，假设最右边1位于m位，减去1，第m为变成0，m位之后都由0变成1，m位之前不变
     * 3. 减去1之后的数 与 n 进行取余，第m位之后的数变成0。 即结果： n最右边为1的位变成0
     * 所以，先减1，然后结果对n取余
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            ++ count;
            // 可以简写为 n &= (n-1);
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 其他思路1：循环检查二进制位
     * 循环检查给定整数 n 的二进制位的每一位是否为 1 （二进制最高为2^31-1，所以循环条件 < 32）
     * 缺点：无论二进制有多少个1，都要循环32次，虽然时间复杂度为O（1），但是实际上还是有很大的优化空间
     */
    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 这里的判断条件不能是 == 1
            if ((n & (1 << i)) != 0) {
                System.out.println((n & (1 << i)));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1InBinary15 test = new NumberOf1InBinary15();
        System.out.println(test.hammingWeight2(11));
        System.out.println(test.hammingWeight2(128));
    }

}

