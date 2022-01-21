package basic;

import java.util.LinkedList;
import java.util.List;

/**
 * description: 回溯 框架
 *
 * @author RenShiWei
 * Date: 2022/1/21 17:29
 **/
public class BackTrack {

    List<List<Integer>> res = new LinkedList<>();

    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            // 排除不合法的选择（视情况）
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

