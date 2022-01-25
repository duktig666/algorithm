package leetcode.codetop;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/12/18 17:30
 **/
public class codetop22_岛屿的数量_200 {

    /** 海洋 */
    final int ZERO = '0';
    /** 未遍历过的岛屿 */
    final int ONE = '1';
    /** 已遍历过的岛屿 */
    final int TWO = '2';

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // 遇到一个岛屿直接标记，有标记 2 ，其他岛屿都进不来，直接标记即可
                if (grid[r][c] == ONE) {
                    isLand(grid, r, c);
                    res++;
                }
            }
        }
        return res;
    }

    private void isLand(char[][] grid, int r, int c) {
        if (! inArea(grid, r, c)) {
            return;
        }

        if (grid[r][c] != ONE) {
            return;
        }
        // 将遍历过的网格，设为2，避免下次重复遍历
        grid[r][c] = TWO;

        isLand(grid, r - 1, c);
        isLand(grid, r + 1, c);
        isLand(grid, r, c - 1);
        isLand(grid, r, c + 1);
    }

    /**
     * 判断是否在网格中
     */
    private boolean inArea(char[][] grid, int row, int col) {
        return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length;
    }

}

