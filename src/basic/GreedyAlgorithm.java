package basic;

/**
 * description: 贪心算法示例
 * <p>
 * 小明手中有 1，5，10，50，100 五种面额的纸币，每种纸币对应张数分别为 5，2，2，3，5 张。若小明需要支付 456 元，则需要多少张纸币？
 * <p>
 * （1）**建立数学模型**
 * 设小明每次选择纸币面额为 Xi ，需要的纸币张数为 n 张，剩余待支付金额为 V ，则有：`X1 + X2 + … + Xn = 456`
 * <p>
 * （2）**问题拆分为子问题**
 * 小明选择纸币进行支付的过程，可以划分为n个子问题，即每个子问题对应为：**在未超过456的前提下，在剩余的纸币中选择一张纸币**。
 * <p>
 * （3）**制定贪心策略，求解子问题**
 * <p>
 * 制定的贪心策略为：在允许的条件下选择面额最大的纸币。则整个求解过程如下：
 * <p>
 * - 选取面值为 100 的纸币，则 `X1 = 100, V = 456 – 100 = 356`；
 * - 继续选取面值为 100 的纸币，则 `X2 = 100, V = 356 – 100 = 256`；
 * - 继续选取面值为 100 的纸币，则 `X3 = 100, V = 256 – 100 = 156`；
 * - 继续选取面值为 100 的纸币，则 `X4 = 100, V = 156 – 100 = 56`；
 * - 选取面值为 50 的纸币，则 `X5 = 50, V = 56 – 50 = 6`；
 * - 选取面值为 5 的纸币，则 `X6 = 5, V = 6 – 5 = 1`；
 * - 选取面值为 1 的纸币，则 `X7 = 1, V = 1 – 1 = 0`；求解结束
 * <p>
 * （4）**将所有解元素合并为原问题的解**
 * <p>
 * 小明需要支付的纸币张数为 7 张，其中面值 100 元的 4 张，50 元 1 张，5 元 1 张，1 元 1 张。
 *
 * @author RenShiWei
 * Date: 2021/9/15 16:20
 **/
public class GreedyAlgorithm {

    int greedyPayment(int payMoney) {
        // 纸币的类型
        int[] moneyType = new int[] {1, 5, 10, 50, 100};
        // 每种纸币的张数
        int[] count = new int[] {5, 2, 2, 3, 5};
        int sum = 0;
        for (int i = moneyType.length - 1; i >= 0 && payMoney > 0; i--) {
            // 贪心算法，每次选取最大的纸币，计算需要的张数
            int temp = Math.min(payMoney / moneyType[i], count[i]);
            // 计算剩余待支付的金额
            payMoney -= temp * moneyType[i];
            sum += temp;
        }
        // 计算完，不够支付，返回-1
        if (payMoney > 0) {
            return - 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        GreedyAlgorithm test = new GreedyAlgorithm();
        System.out.println(test.greedyPayment(456));
    }


}

