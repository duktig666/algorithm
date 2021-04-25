package leetcode.binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description:https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author RenShiWei
 * Date: 2021/4/23 21:37
 **/
public class 寻找重复数_287 {

    /**
     * 方法一：散列表实现
     */
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }

    /**
     * 方法二：借助数组辅助
     */
    public int findDuplicate2(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 方法三：排序后，对比相邻元素是否重复
     */
    public int findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }


    @Test
    public void test() {
        System.out.println(findDuplicate3(new int[] {3, 1, 3, 4, 2}));
    }


}

