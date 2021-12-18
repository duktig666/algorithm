package interview;

import org.junit.Test;

/**
 * description:Vyou微你 笔试——岛屿问题 测试
 *
 * @author RenShiWei
 * Date: 2021/12/18 9:35
 **/
public class SumIsLandEqualSTest {

    SumIsLandEqualS isLandEqualS = new SumIsLandEqualS();

    /**
     * 测试 计算岛屿面积为s的数量
     */
    @Test
    public void sumIslandsTest() {
        /*
            测试用例1：题目所给用例
            预期结果：0
         */
        char[][] grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int s = 8;
        int res = isLandEqualS.sumIslands(grid, s);
        assert res == 0;
        System.out.println(res);

        /*
            测试用例2：修改题目用例的S为9
            预期结果：1
         */
        char[][] grid2 = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int s2 = 9;
        int res2 = isLandEqualS.sumIslands(grid2, s2);
        assert res2 == 1;
        System.out.println(res2);

        /*
            测试用例3：自定义 grid3 和 S
            预期结果：3
         */
        char[][] grid3 = new char[][] {
                {'1', '1', '0', '1', '1'},
                {'1', '0', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '1', '1', '0', '0'}
        };

        int s3 = 3;
        int res3 = isLandEqualS.sumIslands(grid3, s3);
        assert res3 == 3;
        System.out.println(res3);
    }

}

