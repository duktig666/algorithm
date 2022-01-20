package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * description:N皇后 @see https://leetcode-cn.com/problems/n-queens/
 *
 * @author RenShiWei
 * Date: 2021/2/6 15:47
 **/
public class n皇后_51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        //初始化数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        // 记录n皇后的每种符合条件的情况
        List<List<String>> res = new ArrayList<>();
        dfsBacktrack(res, chess, 0);
        return res;
    }

    /**
     * 回溯解决n皇后问题
     *
     * @param res   /
     * @param chess /
     * @param row   /
     */
    private void dfsBacktrack(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfsBacktrack(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    /**
     * 判断当前位置是否可以放置皇后
     *
     * @param chess /
     * @param row   第几行
     * @param col   第几列
     * @return 是否可以放置皇后
     */
    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后,因为他是一行一行往下走的，我们只需要检查走过的行数即可，通俗一点就是判断当前坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 把数组转为list
     *
     * @param chess /
     * @return /
     */
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (char[] chars : chess) {
            path.add(new String(chars));
        }
        return path;
    }

    /**
     * 把二维数组chess中的数据copy一份
     *
     * @param chess /
     * @return /
     */
    private char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }


    /**
     * dfs 解题
     */
    private void dfs(List<List<String>> res, char[][] chess, int row) {
        //终止条件，最后一行都走完了，说明找到了一组，把它加入到集合res中
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        //遍历每一列
        for (int col = 0; col < chess.length; col++) {
            //判断这个位置是否可以放皇后
            if (valid(chess, row, col)) {
                //数组复制一份
                char[][] temp = copy(chess);
                //在当前位置放个皇后
                temp[row][col] = 'Q';
                //递归到下一行继续
                dfs(res, temp, row + 1);
            }
        }
    }

    public static void main(String[] args) {
        n皇后_51 test = new n皇后_51();
        System.out.println(test.solveNQueens(4));
    }

}

