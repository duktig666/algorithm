package leetcode.codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * description:https://leetcode-cn.com/problems/permutations/
 *
 * @author RenShiWei
 * Date: 2022/1/3 14:03
 **/
public class 全排列_46 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 回溯算法
     * 路径：track
     * 选择列表：nums中，不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums  选择列表，不存在于 track 的那些元素
     * @param track 记录的路径
     */
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(track);
            return;
        }
        for (int num : nums) {
            // 排除不合法的选择
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }


}

