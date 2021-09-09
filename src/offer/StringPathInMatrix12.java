package offer;

/**
 * description:剑指Offer第12题——矩阵中的路径 @see https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * @author RenShiWei
 * Date: 2021/9/9 9:33
 **/
public class StringPathInMatrix12 {

    // ------------------剑指offer题解----------------------

    /**
     * 判断矩阵中是否存在存在一条包含str所有字符的路径
     *
     * @param matrix 矩阵
     * @param rows   矩阵的行数
     * @param cols   矩阵的列数
     * @param str    待判断的字符串路径
     * @return 是否存在str的路径
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        // 定义布尔值矩阵（虽然是一个布尔值数组）
        boolean[] visited = new boolean[rows * cols];
        // 定义走到字符串的第几个字符
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 选取一个字符为起点，判断是否存在判定路径
                if (hasPathCore(matrix, rows, cols, i, j, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定路经是否存在
     *
     * @param matrix     矩阵
     * @param rows       矩阵的行数
     * @param cols       矩阵的列数
     * @param row        当前元素行
     * @param col        当前元素列
     * @param str        待判断的字符串路径
     * @param pathLength 走到字符串的第几个字符
     * @param visited    布尔值矩阵
     * @return /
     */
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                               boolean[] visited) {
        // 超出了字符串长度
        if (pathLength > str.length - 1) {
            return true;
        }
        // 定义是否存在路径
        boolean hasPath = false;
        // ①无越界 ②当前矩阵元素 = 当前第i个字符串路径的字符 ③当前路径未走过
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && ! visited[row * cols + col]) {
            // 继续走
            ++ pathLength;
            // 标记上一个已走过
            visited[row * cols + col] = true;
            // 递归下去(上下右左都看一遍)
            hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited);
            // 路径未走通
            if (! hasPath) {
                // 回溯
                -- pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix = new char[] {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = new char[] {'b', 'f', 'c', 'e'};
        char[] strFalse = new char[] {'a', 'b', 'f', 'b'};
        StringPathInMatrix12 solution = new StringPathInMatrix12();
        System.out.println(solution.hasPath(matrix, 3, 4, str));
        System.out.println(solution.hasPath(matrix, 3, 4, strFalse));

        char[][] matrix2 = new char[][] {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String str1 = "bfce";
        String str2 = "abfb";
        System.out.println(solution.exist(matrix2, str1));
        System.out.println(solution.exist(matrix2, str2));
    }

    // ------------------LeetCode题解  仿照上文----------------------

    /**
     * 判断指定路经是否存在
     *
     * @param board 矩阵
     * @param word  路径字符串
     * @return 是否存在路径
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1 || word == null) {
            return false;
        }
        int rows = board.length, cols = board[0].length;
        char[] chars = word.toCharArray();
        // 定义布尔值矩阵（虽然是一个布尔值数组）
        boolean[][] visited = new boolean[rows][cols];
        // 定义走到字符串的第几个字符
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 选取一个字符为起点，判断是否存在判定路径
                if (existCore(board, rows, cols, i, j, chars, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定路经是否存在
     *
     * @param matrix     矩阵
     * @param rows       矩阵的行数
     * @param cols       矩阵的列数
     * @param row        当前元素行
     * @param col        当前元素列
     * @param str        待判断的字符串路径
     * @param pathLength 走到字符串的第几个字符
     * @param visited    布尔值矩阵
     * @return /
     */
    public boolean existCore(char[][] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                             boolean[][] visited) {
        // 超出了字符串长度
        if (pathLength > str.length - 1) {
            return true;
        }
        // 定义是否存在路径
        boolean hasPath = false;
        // ①无越界 ②当前矩阵元素 = 当前第i个字符串路径的字符 ③当前路径未走过
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str[pathLength] && ! visited[row][col]) {
            // 继续走
            ++ pathLength;
            // 标记上一个已走过
            visited[row][col] = true;
            // 递归下去(上下右左都看一遍)
            hasPath = existCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || existCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || existCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || existCore(matrix, rows, cols, row, col - 1, str, pathLength, visited);
            // 路径未走通
            if (! hasPath) {
                // 回溯
                -- pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    // ------------------LeetCode题解  代码优化----------------------

    public boolean exist2(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board 矩阵
     * @param word  字符串路径
     * @param i     矩阵行索引
     * @param j     矩阵列索引
     * @param k     当前目标字符在word中的索引
     * @return 是否存在路径
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //递归终止条件
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        // 当前矩阵元素标记为空字符，代表已经访问过（防止重复访问）
        board[i][j] = '\0';
        // 上下左右四个方向开启下层递归，只要有一个能找到，代表路径存在
        boolean res = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i, j - 1, k + 1);
        // 将当前元素再回复至初始值（只有相等时才会向下走，在这里时，之前的代码 board[i][j] = word[k] 是必然成立）
        board[i][j] = word[k];
        return res;
    }


}

