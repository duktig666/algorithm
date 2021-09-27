package interview;

import org.junit.Test;

/**
 * description: 扑克牌游戏测试
 *
 * @author RenShiWei
 * Date: 2021/9/26 17:00
 **/
public class CardTest {

    /** 豹子 */
    int[][] a = {{14, 1}, {14, 2}, {14, 3}};

    /** 同花顺 */
    int[][] b = {{14, 1}, {13, 1}, {12, 1}};

    /** 同花 */
    int[][] c = {{14, 1}, {12, 1}, {10, 1}};

    /** 顺子 */
    int[][] d = {{14, 1}, {13, 2}, {12, 3}};

    /** 对子 */
    int[][] e = {{14, 1}, {14, 2}, {10, 3}};

    /** 对子 */
    int[][] f = {{6, 1}, {6, 2}, {7, 3}};

    /** 单张 */
    int[][] g = {{2, 1}, {3, 2}, {5, 3}};

    /** 不符合条件的排 */
    int[][] h = {{2, 1}, {3, 2}, {5, 3}, {5, 2}};

    /**
     * 测试区分牌型
     */
    @Test
    public void testGetCardType() {
        Card card = new Card();
        // 豹子
        assert card.getCardType(a)[0] == 1;
        System.out.println("豹子测试：预期结果为1，实际结果为：" + card.getCardType(a)[0]);

        // 同花顺
        assert card.getCardType(b)[0] == 2;
        System.out.println("同花顺测试：预期结果为2，实际结果为：" + card.getCardType(b)[0]);

        // 同花
        assert card.getCardType(c)[0] == 3;
        System.out.println("同花测试：预期结果为3，实际结果为：" + card.getCardType(c)[0]);

        // 顺子
        assert card.getCardType(d)[0] == 4;
        System.out.println("顺子测试：预期结果为4，实际结果为：" + card.getCardType(d)[0]);

        // 对子
        assert card.getCardType(e)[0] == 5;
        System.out.println("对子测试：预期结果为5，实际结果为：" + card.getCardType(e)[0]);

        // 对子
        assert card.getCardType(f)[0] == 5;
        System.out.println("对子测试：预期结果为5，实际结果为：" + card.getCardType(f)[0]);

        // 单张
        assert card.getCardType(g)[0] == 6;
        System.out.println("单张测试：预期结果为6，实际结果为：" + card.getCardType(g)[0]);

        System.out.println("测试不符合条件的排：预期结果为报错，实际结果为：" + card.getCardType(h)[0]);
    }

    /**
     * 测试比较两张牌
     */
    @Test
    public void test2() {
        Card card = new Card();

        assert card.compare(a, b) == 1;
        System.out.println("测试豹子和同花顺比较：预期结果为1，实际结果为：" + card.compare(a, b));

        assert card.compare(b, a) == - 1;
        System.out.println("测试豹子和同花顺比较：预期结果为-1，实际结果为：" + card.compare(b, a));

        assert card.compare(a, a) == 0;
        System.out.println("测试两张牌相同：预期结果为0，实际结果为：" + card.compare(a, a));

        assert card.compare(a, c) == 1;
        System.out.println("测试豹子和同花比较：预期结果为1，实际结果为：" + card.compare(a, c));

        assert card.compare(a, d) == 1;
        System.out.println("测试豹子和顺子比较：预期结果为1，实际结果为：" + card.compare(a, d));

        assert card.compare(e, g) == 1;
        System.out.println("测试对子和单张比较：预期结果为1，实际结果为：" + card.compare(e, g));

        System.out.println("测试输入条件异常：预期结果为报错，实际结果为：" + card.compare(a, h));

        // 省略接下来的测试
    }

}

