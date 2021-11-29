package leetcode.binarysearch;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * description: https://leetcode-cn.com/problems/advantage-shuffle/
 *
 * @author RenShiWei
 * Date: 2021/11/27 19:40
 **/
public class 优势洗牌_870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 从大到小排序的优先队列；数组中第一个元素代表num2中当前元素的索引，第二个元素代表其数值
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new int[] {i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0, right = n - 1;
        int[] res = new int[n];
        // 每次去nums2中最大的
        while (! priorityQueue.isEmpty()) {
            int[] curs = priorityQueue.poll();
            // index为当前最大值的索引
            int index = curs[0], maxValue = curs[1];
            // nums1大于最大值，选取nums1当前的值
            if (nums1[right] > maxValue) {
                res[index] = nums1[right];
                right--;
            } else {
                // nums1小于等于时，选取最差的数
                res[index] = nums1[left];
                left++;
            }
        }
        return res;
    }

}

