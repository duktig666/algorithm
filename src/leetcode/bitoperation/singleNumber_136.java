package leetcode.bitoperation;

/**
 * description: 136. 只出现一次的数字  @see https://leetcode-cn.com/problems/single-number/
 *
 * @author RenShiWei
 * Date: 2021/9/23 15:04
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class singleNumber_136 {

    /**
     * 利用异或的性质，数组所有元素进行异或，剩下的是单一的数。`a ^ b ^ b = a ^ 0 = a`。
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] ^ nums[i - 1];
            if (i == nums.length - 1) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 对上述代码进行优化
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }


}

