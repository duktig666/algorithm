package leetcode.dfs;

/**
 * description:https://leetcode-cn.com/problems/max-area-of-island/
 *
 * @author RenShiWei
 * Date: 2021/12/18 17:03
 **/
public class 岛屿的最大面积_695 {

    /** 0代表海洋 */
    final int ZERO = 0;
    /** 1代表未被遍历过的陆地 */
    final int ONE = 1;
    /** 2代表已被遍历过的陆地 */
    final int TWO = 2;

    /**
     * 计算 岛屿面积最大值
     *
     * @param grid 岛屿和海洋的二维网格
     * @return 岛屿面积最大值
     */
    public int maxAreaOfIsland(int[][] grid) {
        // 记录结果
        int res = 0;
        // 一次遍历网格（area方法中将遍历过的网格设为2，避免重复遍历）
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == ONE) {
                    // 计算当前岛屿的面积
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
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
    private int area(int[][] grid, int row, int col) {
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
    private boolean inArea(int[][] grid, int row, int col) {
        return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length;
    }

}

