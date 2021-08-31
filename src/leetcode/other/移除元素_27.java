package leetcode.other;

import java.util.Arrays;

/**
 * description:
 * 思路：初始思路就是如果元素与val相等于最后一个交换位置，但是最后的元素也可能是val。总想先进行一些判断然后处理，可是这种想法反而会变得复杂。
 * 而官方的题解则是，直接将最后的元素移到当前位置再次检查，这样就避免了这个尴尬的问题（重点的是可能是，for循环和while的区别；for循环每次执行完就要+1，而while则可以自己控制。）
 *
 * @author RenShiWei
 * Date: 2020/12/24 15:30
 **/
public class 移除元素_27 {

    public static void main(String[] args) {
        移除元素_27 test = new 移除元素_27();
        int[] nums = new int[] {3, 2, 2, 3};
        int num = test.removeElement2(nums, 3);
        System.out.println(num);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 不能保持原数组元素不变，如果需要，可借助临时变量将nums[n - 1]=nums[i]
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }

    /**
     * 过于暴力，不管值是否为val，都需要重新为数组的每个元素赋值
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}

