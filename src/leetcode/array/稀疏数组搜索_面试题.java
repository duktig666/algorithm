package leetcode.array;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/sparse-array-search-lcci/
 *
 * @author RenShiWei
 * Date: 2021/5/28 19:26
 **/
public class 稀疏数组搜索_面试题 {

    /**
     * 此题虽然是稀疏数组搜索，但在空间结构上无需转换，转换反而是复杂度提高
     * 最直接的方法就是暴力破解，遍历一次数组直接即可实现
     * 但因为字符串数组是有序的，所以可以采用二分查找法进行解题
     * 注意：因为存在空字符串，需要将mid向左或者向右移动。本方法向右移动，移到最右端还未找到，直接舍弃右区间。
     */
    public int findString(String[] words, String s) {
        int l = 0, r = words.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int temp = m;
            while (m < r && words[m].isEmpty()) {
                m++;
            }
            //到右边还未找到，直接舍弃此区间
            if (r == m) {
                r = temp - 1;
                continue;
            }
            if (words[m].equals(s)) {
                return m;
            } else if (s.compareTo(words[m]) > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return words[l].equals(s) ? l : - 1;
    }

    /**
     * 二分查找法，使用双指针左右寻找举例mid最近的非空字符串，用来确定区间
     * <p>
     * 失败：存在一些测试用例测试失败，目前还未找出问题所在
     */
    public int findString1(String[] words, String s) {
        int l = 0, r = words.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            //确定最近的非空的m
            if (words[m].isEmpty()) {
                int first = m - 1, last = m + 1;
                while (true) {
                    if (first < l && last > r) {
                        return - 1;
                    } else if (first >= l && ! words[first].isEmpty()) {
                        m = first;
                        break;
                    } else if (last <= r && ! words[first].isEmpty()) {
                        m = last;
                        break;
                    }
                    first--;
                    last++;
                }
            }
            if (words[m].equals(s)) {
                return m;
            } else if (s.compareTo(words[m]) > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (l < 0 || l > words.length - 1) {
            return - 1;
        }
        return words[l].equals(s) ? l : - 1;
    }

    @Test
    public void test() {
        String[] arr1 = new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String[] arr2 = new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String s1 = "ta";
        String s2 = "ball";
        System.out.println("二分查找法一：mid向右移动舍弃区间 测试用例");
        System.out.println(findString(arr1, s1));
        System.out.println(findString(arr2, s2));

        System.out.println("二分查找法一：双指针 测试用例");
        System.out.println(findString1(arr1, s1));
        System.out.println(findString1(arr2, s2));
    }


}

