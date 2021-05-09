package leetcode.binarysearch;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * 数组、二分查找
 * <p>
 * 二分法解决判定问题
 *
 * @author RenShiWei
 * Date: 2021/5/9 9:33
 **/
public class 在D天内送达包裹的能力_1011 {

    /**
     * 参看官方题解——二分查找法
     * 题解地址一：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/zai-d-tian-nei-song-da
     * -bao-guo-de-neng-l-ntml/
     * 题解地址二：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/gong-shui-san-xie-li
     * -yong-er-duan-xing-z-95zj/
     * <p>
     * 使用stream流方式，确定最大值和和，实际两次循环，不如一个循环搞定
     * OptionalInt leftOptional = Arrays.stream(weights).max();
     * int left = 0;
     * if (leftOptional.isPresent()) {
     * left = leftOptional.getAsInt();
     * }
     * int right = Arrays.stream(weights).sum();
     */
    public int shipWithinDays(int[] weights, int D) {
        // 确定二分查找左右边界，左边界为包裹最大值，右边界为所有包裹之和（官方题解使用stream流虽然省下代码上的for循环，但实际效率低-两次循环）
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                //超出重量开始计算第二天的包裹运输
                if (cur + weight > mid) {
                    ++ need;
                    cur = 0;
                }
                //未超过当天包裹重量，进行累加
                cur += weight;
            }
            //二分查找法条件判定
            if (need <= D) {
                //当前所需天数小于给定天数，说明运载量太大，缩小右边界
                right = mid;
            } else {
                //当前所需天数大于给定天数，说明运载量太小，扩大左边界
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        System.out.println("---方法一：二分查找法 测试用例---");
        System.out.println(shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(shipWithinDays(new int[] {3, 2, 2, 4, 1, 4}, 3));
        System.out.println(shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4));
    }

}

