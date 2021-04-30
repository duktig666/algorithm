package leetcode.binarysearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description:https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author RenShiWei
 * Date: 2021/4/29 22:19
 **/
public class 有序矩阵中第K小的元素_378 {

    /**
     * 计算排序的第k个元素的位置
     * 暴力破解思路：辅助数组添加所有元素、排序、找下标对应的元素
     * <p>
     * 对于随机访问get和set，ArrayList优于LinkedList，因为LinkedList要移动指针。
     * 对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (k == 1) {
            return matrix[0][0];
        }
        //list也可以替换成数组实现
        List<Integer> list = new ArrayList<>(n * n);
        for (int[] arr : matrix) {
            for (int j = 0; j < n; j++) {
                list.add(arr[j]);
            }
        }
        //排序
        Collections.sort(list);
        return list.get(k - 1);
    }

    /**
     * 每行每列均升序排序,但是整体上换算成一维数组并不是有序的
     * 根据矩阵的可得规律：
     * 1.  matrix[0][0]matrix[0][0] 为最小值，matrix[n - 1][n - 1]matrix[n−1][n−1] 为最大值，将其分别记作 l 和 r
     * 2.  任取一个数 midmid 满足 l<= mid <= r，那么矩阵中不大于 mid 的数，肯定全部分布在矩阵的左上角
     * <p>
     * 思路非常简单：
     * <p>
     * 1.找出二维矩阵中最小的数 leftleft，最大的数 rightright，那么第 kk 小的数必定在 leftleft ~ rightright 之间
     * 2.mid=(left+right) / 2 在二维矩阵中寻找小于等于 mid 的元素个数 count
     * 3.若这个 count小于 k，表明第 k 小的数在右半部分且不包含 mid，即 left=mid+1, right=right，又保证了第 k 小的数在left ~ right 之间
     * 4.若这个 count 大于 k，表明第 k 小的数在左半部分且可能包含 mid，即 left=left, right=mid，又保证了第 k 小的数在left~right之间
     * 5. 因为每次循环中都保证了第 kk 小的数在 left ~ right 之间，当 left==right 时，第 k 小的数即被找出，等于 right
     * 注意：这里的 left mid right 是数值，不是索引位置。
     */
    public int kthSmallest1(int[][] matrix, int k) {
        //行、列索引号
        int row = matrix.length, col = matrix[0].length;
        //最小值和最大值，分别在矩阵左上角和右下角
        int l = matrix[0][0], r = matrix[row - 1][col - 1];
        while (l < r) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = l + (r - l) / 2;
            // 找二维矩阵中 <=mid 的元素总个数
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                //第k小的数在右边，且不包括mid
                l = mid + 1;
            } else {
                //第k小的数在左边，可能包含mid
                r = mid;
            }
        }
        //结束循环条件是 l>=r ,此时r的值其实就是上一次mid的值，所以返回r即代表第k小的元素
        return r;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位从左下角开始找，找到每一列最后一个 <=mid 的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有多少个个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println("---暴力破解测试用例---");
        System.out.println(kthSmallest(new int[][] {{- 5}}, 1));
        System.out.println(kthSmallest(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println("---方法（二分查找）测试用例---");
        System.out.println(kthSmallest1(new int[][] {{- 5}}, 1));
        System.out.println(kthSmallest1(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }

}

