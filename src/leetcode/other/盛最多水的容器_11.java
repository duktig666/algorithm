package leetcode.other;

/**
 * description: https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author RenShiWei
 * Date: 2022/1/25 22:26
 **/
public class 盛最多水的容器_11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            // [left, right] 之间的矩形面积
            int curArea = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, curArea);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

