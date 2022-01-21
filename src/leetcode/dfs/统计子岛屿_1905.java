package leetcode.dfs;

/**
 * description: https://leetcode-cn.com/problems/count-sub-islands/
 *
 * @author RenShiWei
 * Date: 2022/1/20 21:27
 **/
public class 统计子岛屿_1905 {

    /** 海洋 */
    final int OCEAN = 0;
    /** 未遍历过的岛屿 */
    final int LAND = 1;
    /** 已遍历过的岛屿 */
    final int LAND_SEARCHED = 2;

    /**
     * 主函数
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == OCEAN && grid2[i][j] == LAND) {
                    // 这个岛屿肯定不是⼦岛，淹掉
                    dfs(grid2, i, j);
                }
            }
        }
        // 记录封闭岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == LAND) {
                    dfs(grid2, i, j);
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

