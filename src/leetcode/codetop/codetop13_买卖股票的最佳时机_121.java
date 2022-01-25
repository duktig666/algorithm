package leetcode.codetop;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * 这道题可以很直观的 双重for循环可解，但是时间复杂度是O(n^2)的
 *
 * @author RenShiWei
 * Date: 2021/12/16 9:13
 **/
public class codetop13_买卖股票的最佳时机_121 {

    /**
     * 思路：
     * 1. 定义 minPrice 记录股票的最低价 买入
     * 2. 定义 maxProfit 记录股票卖出的最大收益
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int[] arr = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

}

