package leetcode.dfs;

/**
 * description:https://leetcode-cn.com/problems/island-perimeter/
 *
 * @author RenShiWei
 * Date: 2021/12/18 17:11
 **/
public class 岛屿的周长_463 {

    /** 0代表海洋 */
    final int ZERO = 0;
    /** 1代表未被遍历过的陆地 */
    final int ONE = 1;
    /** 2代表已被遍历过的陆地 */
    final int TWO = 2;

    /**
     * 计算岛屿的周长
     */
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == ONE) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    /**
     * DFS遍历
     */
    private int dfs(int[][] grid, int r, int c) {
        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
        if (! inArea(grid, r, c)) {
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
        if (grid[r][c] == ZERO) {
            return 1;
        }
        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if (grid[r][c] != ONE) {
            return 0;
        }
        grid[r][c] = TWO;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    /**
     * 判断坐标 (r, c) 是否在网格中
     */
    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

}

