package leetcode.codetop;

/**
 * description:https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 思路1：nums2放到nums1后，直接进行排序
 * <p>
 * 思路2：双指针，正序，但需要借助 m+n 的辅助空间
 * <p>
 * 思路3：逆序双指针，分别指向nums1和nums2的尾部，然后逆序插入
 *
 * @author RenShiWei
 * Date: 2021/12/17 9:11
 **/
public class 合并两个有序数组_88 {

    /**
     * 思路：
     * 1. 逆序双指针，分别指向nums1和nums2的尾部，然后循环遍历
     * 2. nums1赋值一个元素，p1--;nums2,p2--
     * 3. 只要赋值一个元素tail--
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == - 1) {
                cur = nums2[p2--];
            } else if (p2 == - 1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

}

