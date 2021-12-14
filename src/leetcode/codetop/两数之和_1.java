package leetcode.codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description:https://leetcode-cn.com/problems/two-sum/
 *
 * @author RenShiWei
 * Date: 2021/12/14 20:32
 **/
public class 两数之和_1 {

    /**
     * 思路：
     * 1. 最原始的思路，使用双重for循环，遍历两数的结果（直接从当前i之后进行第二次遍历）
     * 但是这样的解法，时间复杂度是O(n)，空间复杂度O(1)
     * 2. 可以使用 map 记录元素及下标，然后再次进行比对。时间复杂度是O(1)，空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 思路：
     * 1. 先对数组进行排序
     * 2. 定义双指针，右指针找到 小于等于 target的元素
     * 3. 依次双指针 和 进行判断
     * 3.1 和小于target，移动左指针
     * 3.2 和大于target，移动右指针
     * 4. 题目假设只会对应一个答案，所以重复元素先暂时不做过多考虑
     * <p>
     * 结果：
     * 思路失败，先排序 那么下标会错乱
     * <p>
     * 改进思路：
     * 按照现在的逻辑进行改进，可以先扫描一遍数组，用map记录元素下标和索引
     */
    public int[] twoSumTmp1(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        // 记录结果
        int[] res = new int[2];
        // 定义双指针
        int l = 0, r = nums.length - 1;
        // 双指针重合时，说明已经扫描结束
        while (l < r) {
            if (nums[r] > target) {
                r--;
                continue;
            }
            int temp = nums[l] + nums[r];
            if (temp > target) {
                r--;
            } else if (temp < target) {
                l++;
            } else {
                res[0] = l;
                res[1] = r;
                break;
            }
        }
        return res;
    }

}

