package basic;

/**
 * description:前缀和 框架
 *
 * @author RenShiWei
 * Date: 2021/11/22 13:58
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class PrefixSum {

    /** 前缀和数组 prefix[i]代表nums[0,i-1]的和 */
    private int[] prefix;

    /**
     * 输⼊⼀个数组，构造前缀和
     */
    public PrefixSum(int[] nums) {
        prefix = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    /**
     * 查询闭区间 [i, j] 的累加和
     */
    public int query(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

}

