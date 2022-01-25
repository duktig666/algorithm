package leetcode.codetop;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2022/1/25 21:17
 **/
public class 接雨水_42 {

    /**
     * 双指针：
     * 边走边算，哪边小哪边索引++，只关注左右两边低的柱子
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        // l_max 是 height[0..left] 中最高柱子的高度，r_max 是 height[right..end] 的最高柱子的高度
        int lMax = 0, rMax = 0;

        int res = 0;
        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            /* res += min(l_max, r_max) - height[i]

               l_max 是 left 指针左边的最高柱子，但是 r_max 并不一定是 left 指针右边最高的柱子
               我们只在乎 min(l_max, r_max)，我们已经知道 l_max < r_max 了，至于这个 r_max 是不是右边最大的，不重要。
               重要的是 height[i] 能够装的水只和较低的 l_max 之差有关
             */
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }

    /**
     * 备忘录优化：利用两个数组提前计算 i 位置的，左边最大值和右边最大值
     * <p>
     * 时间复杂度 O(N)，空间复杂度 O(N)
     */
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        int[] lMax = new int[n];
        int[] rMax = new int[n];

        // 初始化 base case
        lMax[0] = height[0];
        rMax[n - 1] = height[n - 1];

        // 从左向右计算 l_max
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }
        // 计算答案
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }


    /**
     * 暴力破解：
     * 1. 分别找到当前位置左边和右边的最大高度
     * 2. 左边和右边最大高度取最小值 - 当前高度 = 当前位置可接的雨水
     * 3. 遍历累加每个位置可接的雨水
     * <p>
     * 时间复杂度 O(N^2)，空间复杂度 O(1)
     */
    public int trap1(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int lMax = 0, rMax = 0;
            // 找右边最高的柱子
            for (int j = i; j < n; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            // 找左边最高的柱子
            for (int j = i; j >= 0; j--) {
                lMax = Math.max(lMax, height[j]);
            }
            // 如果自己就是最高的话，
            // l_max == r_max == height[i]
            res += Math.min(lMax, rMax) - height[i];
        }
        return res;
    }

}

