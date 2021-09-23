package beauty.bitoperation;

/**
 * 功能描述：算法——删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 要求：不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author RenShiWei
 * Date: 2020/3/12 18:12
 **/
public class 删除排序数组中的重复项_26_leetcode {

    /**
     * 方法一:每次遇到重复的数，将第二个一次移动到当前length的最后一个位置
     */
    public static int removeDuplicates(int[] nums) {
        //记录去除重复的数组长度
        int length = nums.length;
        //快慢指针
        int start = 0, end = 1;
        while (end < length) {
            //如果有重复，一次交换元素，到数组末尾
            if ((nums[start] ^ nums[end]) == 0) {
                for (int j = end; j < length - 1; j++) {
                    swapArr(nums, j, j + 1);
                }
                //每次数组长度-1
                length--;
            } else {
                //从新的数开始
                start = end;
                end = start + 1;
            }
        }
        return length;
    }

    /**
     * 方法二———对方法一进行优化
     */
    public static int removeDuplicates2(int[] nums) {
        //记录去除重复的数组长度
        int length = nums.length;
        //快慢指针
        int start = 0;
        while (start < (length - 1)) {
            //如果有重复，一次交换元素，到数组末尾
            if ((nums[start] ^ nums[start + 1]) == 0) {
                for (int j = start + 1; j < (length - 1); j++) {
                    swapArr(nums, j, j + 1);
                }
                //每次数组长度-1
                length--;
            } else {
                //从新的数开始
                start++;
            }
        }
        return length;
    }

    /**
     * 方法三——遇到不重复的数，直接在原数组中从0开始赋值（改变了原有数组的数据量）
     * 官方题解
     *
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void swapArr(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates2(arr));
    }

}

