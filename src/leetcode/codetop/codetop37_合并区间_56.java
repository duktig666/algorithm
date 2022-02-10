package leetcode.codetop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * description: https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author RenShiWei
 * Date: 2022/2/10 10:23
 **/
public class codetop37_合并区间_56 {

    public int[][] merge(int[][] intervals) {
        // 按照 start 对区间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> res = new LinkedList<>();
        // 添加第一个方便之后比较
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 当前区间
            int[] curr = intervals[i];
            // res 中最后一个元素的引用（待比较区间）
            int[] last = res.getLast();
            if (curr[0] <= last[1]) {
                // 合并区间
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // 处理下一个待合并区间
                res.add(curr);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}

