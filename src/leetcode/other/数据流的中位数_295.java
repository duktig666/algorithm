package leetcode.other;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * description:295. 数据流的中位数 https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * @author RenShiWei
 * Date: 2021/12/3 16:27
 **/
public class 数据流的中位数_295 {

    static class MedianFinder {

        PriorityQueue<Integer> large;
        PriorityQueue<Integer> small;

        public MedianFinder() {
            // 小顶堆
            large = new PriorityQueue<>();
            // 大顶堆
            small = new PriorityQueue<>((a, b) -> b - a);
        }

        public double findMedian() {
            // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
            if (large.size() < small.size()) {
                return small.peek();
            } else if (large.size() > small.size()) {
                return large.peek();
            }
            // 如果元素一样多，两个堆堆顶元素的平均数是中位数
            return (large.peek() + small.peek()) / 2.0;
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(Objects.requireNonNull(small.poll()));
            } else {
                large.offer(num);
                small.offer(Objects.requireNonNull(large.poll()));
            }
        }
    }

}

