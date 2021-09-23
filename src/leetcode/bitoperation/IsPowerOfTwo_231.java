package leetcode.bitoperation;

/**
 * description:leetcode 231. 2 的幂 @see https://leetcode-cn.com/problems/power-of-two/
 *
 * @author RenShiWei
 * Date: 2021/9/23 15:37
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class IsPowerOfTwo_231 {

    /**
     * 整数是2的整数次方的数，二进制只有一个1
     * <p>
     * 如果可以一次消除1之后变为0，说明是2的整数次方。
     * <p>
     * `(n - 1) & n` 可以消除二进制中最后边的一个1
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }

}

