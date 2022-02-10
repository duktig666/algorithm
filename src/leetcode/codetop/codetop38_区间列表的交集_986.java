package leetcode.codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * description: https://leetcode-cn.com/problems/interval-list-intersections/
 *
 * @author RenShiWei
 * Date: 2022/2/10 11:26
 **/
public class codetop38_区间列表的交集_986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];

            // 交集的情况
            if (b2 >= a1 && a2 >= b1) {
                res.add(new int[] {
                        Math.max(a1, b1), Math.min(a2, b2)
                });
            }

            // 指针前进
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[0][0]);
    }

}

