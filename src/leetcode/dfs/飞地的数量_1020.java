package leetcode.dfs;

/**
 * description: https://leetcode-cn.com/problems/number-of-enclaves/
 *
 * @author RenShiWei
 * Date: 2022/1/20 21:21
 **/
public class 飞地的数量_1020 {

    /** 海洋 */
    final int OCEAN = 0;
    /** 未遍历过的岛屿 */
    final int LAND = 1;
    /** 已遍历过的岛屿 */
    final int LAND_SEARCHED = 2;

    /**
     * 主函数
     */
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 上下边缘 淹没
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        // 左右边缘 淹没
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        // 记录封闭岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 岛屿的通用遍历方法
     * 统计过一片岛屿后，将其淹没
     */
    private void dfs(int[][] grid, int r, int c) {
        // 不在网格直接返回
        if (! inArea(grid, r, c)) {
            return;
        }
        // 不是陆地直接返回
        if (grid[r][c] != LAND) {
            return;
        }
        // 遍历过的格子 置为 2
        grid[r][c] = LAND_SEARCHED;

        // 递归走四个方向
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    /**
     * 判断是否在网格当中
     */
    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length;
    }

}

