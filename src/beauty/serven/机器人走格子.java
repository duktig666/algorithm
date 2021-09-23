package beauty.serven;

/**
 * 功能描述：算法——机器人走格子
 * 有一个X*Y的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 清设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y,请返回机器人的走法数目。保证X +y小于等于12。
 * <p>
 * f(x,y)=f(x,y-1)+f(x-1,y)
 *
 * @author RenShiWei
 * Date: 2020/5/4 15:41
 **/
public class 机器人走格子 {

    /**
     * 递归解题
     *
     * @param x
     * @param y
     * @return
     */
    static int solve ( int x, int y ) {
        if (x == 1 || y == 1) {
            return 1;
        }
        return solve(x - 1, y) + solve(x, y - 1);
    }

    /**
     * 递推解决（循环+缓存）
     *
     * @param x
     * @param y
     * @return
     */
    static int solve2 ( int x, int y ) {
        int[][] state = new int[x + 1][y + 1];
        //第一行和第一列都是1
        for (int i = 1; i <= y; i++) {
            state[1][i] = 1;
        }
        for (int i = 1; i <= x; i++) {
            state[i][1] = 1;
        }

        for (int i = 2; i <= x; i++) {
            for (int j = 2; j <= y; j++) {
                state[i][j] = state[i][j - 1] + state[i - 1][j];
            }
        }
        return state[x][y];
    }

}

