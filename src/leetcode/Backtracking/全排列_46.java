package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * description: 全排列 @see https://leetcode-cn.com/problems/permutations/
 *
 * @author RenShiWei
 * Date: 2021/9/9 14:56
 **/
public class 全排列_46 {

    //----------利用linkedList存储 回溯法 实现------------

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
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
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

    // --------------------优化 dfs ------------------

    public List<List<Integer>> permute2(int[] nums) {
        // 存储所有种可能的情况
        List<List<Integer>> res = new ArrayList<>();
        // 添加所有的元素
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        // 全排列的元素个数
        int n = nums.length;
        // 深度优先搜索进行处理
        dfs(n, output, res, 0);
        return res;
    }

    public void dfs(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            dfs(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


    // --------------另一种题型——统计全排列的情况个数----------------


    public static int[] arr = new int[5];
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int k) {
        if (k == arr.length) {
            count++;
        } else {
            for (int i = k; i < arr.length; i++) {
                swap(k, i);
                dfs(k + 1);
                swap(k, i);
            }
        }
    }

    public static void swap(int k, int i) {
        int t = arr[k];
        arr[k] = arr[i];
        arr[i] = t;
    }

}

