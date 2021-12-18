package leetcode.dfs;

import org.junit.Test;

/**
 * description:Vyou微你 笔试——岛屿问题
 *
 * @author RenShiWei
 * Date: 2021/12/18 9:35
 **/
public class SumIsLandEqualS {

    /** 0代表海洋 */
    final char ZERO = '0';
    /** 1代表未被遍历过的陆地 */
    final char ONE = '1';
    /** 2代表已被遍历过的陆地 */
    final char TWO = '2';

    /**
     * 计算 岛屿面积为s的数量
     *
     * @param grid 岛屿和海洋的二维网格
     * @param s    岛屿面积
     * @return 岛屿面积为s的数量
     */
    public int sumIslands(char[][] grid, int s) {
        // 记录结果
        int res = 0;
        // 一次遍历网格（area方法中将遍历过的网格设为2，避免重复遍历）
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == ONE) {
                    // 计算当前岛屿的面积
                    int landArea = area(grid, row, col);
                    if (landArea == s) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 递归计算岛屿的面积（将遍历过的网格设为2，避免重复计算）
     *
     * @param grid 岛屿和海洋的二维网格
     * @param row  行索引
     * @param col  列索引
     * @return 当前岛屿的面积
     */
    private int area(char[][] grid, int row, int col) {
        // 越界，停止递归
        if (! inArea(grid, row, col)) {
            return 0;
        }
        // 当前网格遍历过，停止递归
        if (grid[row][col] != ONE) {
            return 0;
        }
        // 将遍历过的网格，设为2，避免下次重复遍历
        grid[row][col] = TWO;

        // 递归计算岛屿的面积
        return 1
                + area(grid, row - 1, col)
                + area(grid, row + 1, col)
                + area(grid, row, col - 1)
                + area(grid, row, col + 1);
    }

    /**
     * 判断网格遍历时，是否越界
     *
     * @param grid 岛屿和海洋的二维网格
     * @param row  行索引
     * @param col  列索引
     * @return 是否越界
     */
    private boolean inArea(char[][] grid, int row, int col) {
        return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length;
    }

    /**
     * 测试 计算岛屿面积为s的数量
     */
    @Test
    public void sumIslandsTest() {
        char[][] grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int s = 8;
        int res = sumIslands(grid, s);
        System.out.println(res);

        char[][] grid2 = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int s2 = 9;
        int res2 = sumIslands(grid2, s2);
        System.out.println(res2);

        char[][] grid3 = new char[][] {
                {'1', '1', '0', '1', '1'},
                {'1', '0', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '1', '1', '0', '0'}
        };

        int s3 = 3;
        int res3 = sumIslands(grid3, s3);
        System.out.println(res3);
    }

}

