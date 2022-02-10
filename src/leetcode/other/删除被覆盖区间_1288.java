package leetcode.other;

import java.util.Arrays;

/**
 * description: https://leetcode-cn.com/problems/remove-covered-intervals/
 *
 * @author RenShiWei
 * Date: 2022/2/10 10:07
 **/
public class 删除被覆盖区间_1288 {

    /**
     * 区间覆盖问题 思路：
     * 1. 区间排序，排序规则：起点升序排列，起点相同时终点降序排列
     * 2. 根据情况判断
     * 2.1 情况一，找到了覆盖区间（记录覆盖区间的数量）
     * 2.2 情况二，两个区间可以合并，成一个大区间
     * 2.3 情况三，两个区间完全不相交
     * 3. 计算剩余区间（总区间数-覆盖区间数）
     */
    public int removeCoveredIntervals(int[][] intervals) {
        // 按照起点升序排列，起点相同时终点降序排列
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 记录合并区间的起点和终点（初始化为第一个区间）
        int left = intervals[0][0];
        int right = intervals[0][1];

        // 统计覆盖区间的数量
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            // 情况一，找到覆盖区间
            if (left <= intv[0] && right >= intv[1]) {
                res++;
            }
            // 情况二，找到相交区间，合并
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }
            // 情况三，完全不相交，更新起点和终点
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        // 返回剩余的区间数
        return intervals.length - res;
    }

}

