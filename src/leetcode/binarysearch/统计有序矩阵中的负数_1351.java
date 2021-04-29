package leetcode.binarysearch;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * @author RenShiWei
 * Date: 2021/4/29 17:00
 **/
public class 统计有序矩阵中的负数_1351 {

    /**
     * 思考：
     * 正常解法：无非就是双重循环判断每一个元素是否为负数，进行sum。但是时间复杂度太高，为O(n ^ 2)
     * 规律：根据题意可得，矩阵无论行和列都是递减的，所以无论是行还是列，找到第一个负数之后，后续的数都是负数
     * 解法一：遍历每行，每行的元素使用二分查找法。可将时间复杂度降低为O(n*logn)
     */
    public int countNegatives(int[][] grid) {
        int mark = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] temp = grid[i];
            int start = 0, end = temp.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (temp[0] < 0) {
                    mark += temp.length;
                    break;
                }
                if (temp[temp.length - 1] > 0) {
                    break;
                }
                if (temp[mid] >= 0) {
                    if (mid + 1 <= temp.length - 1 && temp[mid + 1] >= 0) {
                        start = mid + 1;
                    } else {
                        mark += temp.length - (mid + 1);
                        break;
                    }
                } else {
                    end = mid - 1;
                }
            }
        }
        return mark;
    }

    /**
     * 解法二：官方题解三（分治法）
     * 对于上述解法，利用了行递减，但其实列也是递减的；每行的负数索引位置也是递减的
     * 利用递归计算中间行，分为两部分计算
     */
    public int countNegatives2(int[][] grid) {
        return solve(0, grid.length - 1, 0, grid[0].length - 1, grid);
    }

    int solve(int columnL, int columnR, int rowL, int rowR, int[][] grid) {
        //递归结束条件
        if (columnL > columnR) {
            return 0;
        }
        int mid = columnL + (columnR - columnL) / 2;
        //第一个负数位置
        int pos = - 1;
        for (int i = rowL; i <= rowR; ++ i) {
            //找到中间行的第一个负数的位置
            if (grid[mid][i] < 0) {
                pos = i;
                break;
            }
        }
        int ans = 0;
        if (pos >= 0) {
            //计算中间行负数个数
            ans += grid[0].length - pos;
            //计算上半部分
            ans += solve(columnL, mid - 1, pos, rowR, grid);
            //计算下半部分
            ans += solve(mid + 1, columnR, rowL, pos, grid);
        } else {
            //全是正数的处理
            ans += solve(mid + 1, columnR, rowL, rowR, grid);
        }
        return ans;
    }

    /**
     * 解法三：官方题解四（倒序遍历）
     * 如果已经计算出第i行的负数索引为pos，第i+1行的负数在[0,pos]中，所以接下来就可以进行倒着遍历计算
     */
    public int countNegatives3(int[][] grid) {
        int pos = grid[0].length - 1;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] temp = grid[i];
            //如果全都是正数，跳过当前行
            if (temp[grid[0].length - 1] >= 0) {
                continue;
            }
            //如果全都是负数，累加
            if (temp[0] < 0) {
                num += grid[0].length;
            }
            for (int j = pos; j >= 0; -- j) {
                if (temp[j] >= 0) {
                    if (j + 1 < grid[0].length) {
                        //重置下一行计算负数区间的位置
                        pos = j + 1;
                        //如果是最后一个元素，说明没有元素；否则累加
                        num += grid[0].length - pos;
                    }
                    break;
                }
            }

        }
        return num;
    }


    @Test
    public void test() {
        int[][] grid = new int[][] {{4, 3, 2, - 1}, {3, 2, 1, - 1}, {1, 1, - 1, - 2}, {- 1, - 1, - 2, - 3}};
        System.out.println(countNegatives(grid));
        System.out.println(countNegatives2(grid));
        System.out.println(countNegatives3(grid));
    }
}

