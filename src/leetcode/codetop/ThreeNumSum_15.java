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
public class ThreeNumSum_15 {

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
        ThreeNumSum_15 test = new ThreeNumSum_15();
        int[] nums = new int[] {- 1, 0, 1, 2, - 1, - 4};
        System.out.println(test.threeSum(nums));
    }

}

