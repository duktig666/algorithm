package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description:https://leetcode-cn.com/problems/subsets/
 *
 * @author RenShiWei
 * Date: 2022/1/19 20:47
 **/
public class 子集_78 {

    /** 记录结果 */
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 主函数
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums  选择列表，不存在于 track 的那些元素
     * @param cur   当前位置
     * @param track 记录的路径
     */
    private void backtrack(int[] nums, int cur, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = cur; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track);
            // 撤销选择
            track.removeLast();
        }

    }

    /**
     * 回溯算法2
     * 原序列的每个位置在答案序列中的状态有被选中和不被选中两种
     *
     * @param nums  选择列表，不存在于 track 的那些元素
     * @param cur   当前位置
     * @param track 记录的路径
     */
    private void backtrack2(int[] nums, int cur, LinkedList<Integer> track) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 考虑选择当前位置
        track.add(nums[cur]);
        backtrack(nums, cur + 1, track);
        // 回溯，撤销选择
        track.removeLast();
        // 考虑不选择当前位置
        backtrack(nums, cur + 1, track);
    }

}

