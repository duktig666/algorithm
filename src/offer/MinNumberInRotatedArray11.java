package offer;

/**
 * description:旋转数组的最小数字 @see https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author RenShiWei
 * Date: 2021/9/7 9:04
 **/
public class MinNumberInRotatedArray11 {

    /**
     * 查找旋转数组中的最小值
     */
    public int minArray(int[] numbers) {
        // 左右两个指针
        int index1 = 0, index2 = numbers.length - 1;
        // 初始中间值指向index1，数组只有一个升序序列，直接返回第一个元素（即旋转0个元素的情况）
        int mid = index1;
        while (numbers[index1] >= numbers[index2]) {
            // 左右指针相邻，index2右侧指针代表最小值
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }

            mid = index1 + ((index2 - index1) >> 1);

            // index1 = index2 = mid 无法用二分法进行判断，需要遍历找出最小值
            if (numbers[index1] == numbers[index2] && numbers[mid] == numbers[index1]) {
                return minInOrder(numbers, index1, index2);
            }
            //二分法指针调整
            if (numbers[mid] >= numbers[index1]) {
                index1 = mid;
            } else if (numbers[mid] <= numbers[index2]) {
                index2 = mid;
            }
        }
        return numbers[mid];
    }

    /**
     * 遍历法 找出指定序列的最小值
     */
    private int minInOrder(int[] numbers, int index1, int index2) {
        int min = numbers[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

}

