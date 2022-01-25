package leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description:15.三数之和  @see https://leetcode-cn.com/problems/3sum/
 *
 * @author RenShiWei
 * Date: 2021/11/16 15:48
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class codetop7_三数之和_15 {

    /**
     * 思路：
     * 1. 数组元素排序
     * 2. 遍历（到倒数第三个元素截止）
     * 3. for循环需要遍历每一个元素，然后再进行双指针判断
     * 3.1 如果第一个数大于0，后边都比它大，不成立，直接退出遍历
     * 3.2 去掉重复的情况，如果当前元素与前一个元素相同，continue
     * 3.2 第一个元素取反，target 等于 剩下两个元素的和，即条件成立
     * 4. 双指针，判断剩下两个元素和是否等于 target
     * 4.1 nums[left] + nums[right] == target
     * 4.1.1 添加到结果集合
     * 4.1.2 left++ right--
     * 4.1.3 left和right与前一个元素相同，继续走（结果集合不添加 重复结果）
     * 4.2 小于 left++
     * 4.3 大于 right--
     * 5. 进入下一次for循环
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return sumList;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                // 第一个数大于 0，后面的数都比它大，肯定不成立了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去掉重复情况
                continue;
            }
            // 剩下两个数目标值（取相反数）
            int target = - nums[i];
            // 定义剩下两个数的指针
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    sumList.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1,
                    // 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        codetop7_三数之和_15 test = new codetop7_三数之和_15();
        int[] nums = new int[] {- 1, 0, 1, 2, - 1, - 4};
        System.out.println(test.threeSum(nums));
    }

}

