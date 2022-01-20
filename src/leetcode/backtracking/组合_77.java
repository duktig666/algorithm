package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description: https://leetcode-cn.com/problems/combinations/
 *
 * @author RenShiWei
 * Date: 2022/1/20 10:09
 **/
public class 组合_77 {

    /** 记录结果 */
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, 1, k, track);
        return res;
    }

    private void backtrack(int n, int start, int k, LinkedList<Integer> track) {
        // 剪枝：track 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (track.size() + (n - start + 1) < k) {
            return;
        }
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, i + 1, k, track);
            track.removeLast();
        }
    }

    private void backtrack2(int n, int start, int k, LinkedList<Integer> track) {
        // 剪枝：track 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (track.size() + (n - start + 1) < k) {
            return;
        }

        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 考虑选择当前位置
        track.add(start);
        backtrack2(n, start + 1, k, track);
        track.removeLast();
        // 考虑不选择当前位置
        backtrack2(n, start + 1, k, track);
    }

}

