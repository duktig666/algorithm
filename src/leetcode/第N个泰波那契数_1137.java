package leetcode;

/**
 * description:力扣第1137题  https://leetcode-cn.com/problems/n-th-tribonacci-number/
 *
 * @author RenShiWei
 * Date: 2021/2/17 15:08
 **/
public class 第N个泰波那契数_1137 {

    /**
     * 思路一：
     * 根据题意直接写递归方法，虽然执行的测试用例的结果正确，但是在力扣上提交的时候出现了超出时间限制
     * 时间复杂度 3 ^ n
     *
     * @param n /
     * @return 第N个泰波那契数
     */
    public static int tribonacci1(int n) {
        //终止条件
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        //调用自己
        return tribonacci1(n - 1) + tribonacci1(n - 2) + tribonacci1(n - 3);
    }

    /**
     * 思路：因为题意中说明n<38，所以可以将前38项的结果计算出来，存储到静态数组当中，每次执行，直接检索即可。但是空间复杂度达到了n 不在考虑范围之内
     * <p>
     * 思路二：动态计算，内存当中保留不超过3个泰波那契数
     * <p>
     * 空间优化，动态计算（迭代实现）
     * <p>
     * 时间复杂度：O(N)。
     * 空间复杂度：O(1)，保存最后 3 个斐波那契数
     *
     * @param n /
     * @return 第N个泰波那契数
     */
    public static int tribonacci2(int n) {
        if (n < 3) {
            return n == 0 ? 0 : 1;
        }

        int temp, x = 0, y = 1, z = 1;
        //每次只在内存当中维护3个泰波那契数
        for (int i = 3; i <= n; i++) {
            temp = x + y + z;
            x = y;
            y = z;
            z = temp;
        }
        return z;
    }

    static class Tri {

        private int n = 38;
        public int[] nums = new int[n];

        /**
         * 初始化，计算38个泰波那契数，存到静态数组中
         */
        Tri() {
            nums[1] = 1;
            nums[2] = 1;
            helper(n - 1);
        }

        int helper(int k) {
            if (k == 0) {
                return 0;
            }
            if (nums[k] != 0) {
                return nums[k];
            }

            nums[k] = helper(k - 1) + helper(k - 2) + helper(k - 3);
            return nums[k];
        }

    }

    /**
     * 思路三：性能优化：带记忆的递归
     * 初始化一个数组 nums 用于保存斐波那契数，并记录前 3 个斐波那契数。
     * 从预计算的数组中检索所需的斐波那契数。
     * <p>
     * 时间复杂度：O(1)，预计算 38 个斐波那契数，并在数组中检索。
     * <p>
     * 空间复杂度：O(1)，存储 38 个斐波那契数的数组。
     *
     * @param n /
     * @return 第N个泰波那契数
     */
    public static int tribonacci3(int n) {
        Tri t = new Tri();
        return t.nums[n];
    }

    /**
     * 思路四：性能优化：动态计算（将思路三的递归实现改为迭代实现，优化性能）
     * 初始化一个数组用于保存斐波那契数，并初始化前 3 个斐波那契数字。
     * <p>
     * i 从 3 循环到 38，每一步计算出一个新的斐波那契数：nums[i] = helper(i - 1) + helper(i - 2) + helper(i - 3)
     * 从数组中检索所需的斐波那契数
     *
     * @param n /
     * @return 第N个泰波那契数
     */
    public static int tribonacci4(int n) {
        TriBo t = new TriBo();
        return t.nums[n];
    }

    static class TriBo {
        private int n = 38;
        public int[] nums = new int[n];

        TriBo() {
            nums[1] = 1;
            nums[2] = 1;
            for (int i = 3; i < n; ++ i) {
                nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
            }
        }
    }

}

