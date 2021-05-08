package leetcode.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 * <p>
 * 数组、字符串、二分查找
 *
 * @author RenShiWei
 * Date: 2021/5/6 22:01
 **/
public class 比较字符串最小字母出现频次_1170 {

    /**
     * 方法一——暴力破解：循环遍历比较
     * 思想:
     * ①遍历words，得知每个元素的 最小字母的出现频次；用words辅助数组记录，方便之后每次进行比较
     * ②遍历queries得知每一个元素的最小字母的出现频次，与words辅助数组比较，小于则结果累加，记录到结果数组中
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queriesArr = new int[queries.length];
        int[] wordArr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordArr[i] = stringMinCount(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            int num = stringMinCount(queries[i]);
            int res = 0;
            for (int value : wordArr) {
                if (num < value) {
                    res++;
                }
            }
            queriesArr[i] = res;
        }
        return queriesArr;
    }

    /**
     * 统计字符串中字典序最小字母的出现次数
     */
    private int stringMinCount(String s) {
        int num = 1;
        char temp = s.charAt(0);
        for (int j = 1; j < s.length(); j++) {
            if (temp > s.charAt(j)) {
                temp = s.charAt(j);
                num = 1;
            } else if (temp == s.charAt(j)) {
                num++;
            }
        }
        return num;
    }

    /**
     * 方法二——从后往前对比words频次（参看题解）
     * 思考：上一个方法，将words的结果缓存下来，用来比较。在一定程度上比每次遍历都计算words结果的效率高，但是每次都还要双重遍历。
     * 优化思路：words每个元素最多10个字符，所以最小字母频次不会大于10（用11的数组，0无意义）。将数组设置为频次为索引，值为出现的次数。
     * 遍历queries，每次从words后向前比较，queries最小字母频次小于words下标+1，大于直接跳出循环
     */
    public int[] numSmallerByFrequency1(String[] queries, String[] words) {
        int[] queriesArr = new int[queries.length];
        int[] wordArr = new int[11];
        int count;
        for (String word : words) {
            count = stringMinCount(word);
            wordArr[count] += 1;
        }

        int num;
        for (int i = 0; i < queries.length; i++) {
            num = stringMinCount(queries[i]);
            int res = 0;
            for (int j = wordArr.length - 1; j > 0; j--) {
                if (wordArr[j] > 0) {
                    if (num < j) {
                        res += wordArr[j];
                    } else {
                        break;
                    }
                }
            }
            queriesArr[i] = res;
        }
        return queriesArr;
    }

    /**
     * 方法三：前缀和（参看题解）
     * 方法二还需要从后往前遍历，依然是双重遍历。前缀和解决求数组连续子数组和的问题
     * 最后一个元素的值减去不符合条件的值，就是所求的值
     * 当前元素是之前所有元素的和
     */
    public int[] numSmallerByFrequency2(String[] queries, String[] words) {
        int[] queriesArr = new int[queries.length];
        int[] wordArr = new int[11];
        int count;
        for (String word : words) {
            count = stringMinCount(word);
            wordArr[count] += 1;
        }

        // 前缀和操作
        for (int i = 1; i < 11; i++) {
            wordArr[i] = wordArr[i] + wordArr[i - 1];
        }

        int num;
        for (int i = 0; i < queries.length; i++) {
            num = stringMinCount(queries[i]);
            queriesArr[i] = wordArr[10] - wordArr[num];
        }
        return queriesArr;
    }

    /**
     * 思考：本题标签有二分查找法，但是前提是有序的，对queries和words数组中的string分别计算字典序最小char个数，形成两个数组queriesArr和wordArr
     * 对wordArr数组排序，使用二分法找到wordArr中大于queriesArr[i]的index，也就找到了答案
     * 方法四——二分法
     */
    public int[] numSmallerByFrequency3(String[] queries, String[] words) {
        int[] queriesArr = new int[queries.length];
        int[] wordArr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordArr[i] = stringMinCount(words[i]);
        }
        Arrays.sort(wordArr);
        int num;
        for (int i = 0; i < queries.length; i++) {
            num = stringMinCount(queries[i]);
            queriesArr[i] = binarySearchByLoop(wordArr, num);
        }
        return queriesArr;
    }

    /**
     * description:二分查找的稍微更改，寻找第一个比queryNum大的值，并统计其后还有多少值
     */
    public int binarySearchByLoop(int[] arr, int num) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            //防止出现越界
            int mid = start + (end - start) / 2;
            if (arr[mid] > num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        //注意这里，等于也是不符合条件的。
        if (arr[start] <= num) {
            return 0;
        } else {
            return arr.length - start;
        }
    }

    @Test
    public void test() {
        System.out.println("---方法一——暴力破解：循环遍历比较 测试用例---");
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[] {"cbd"}, new String[] {"zaaaz"})));
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[] {"bbb", "cc"}, new String[] {"a", "aa",
                "aaa", "aaaa"})));

        System.out.println("---方法二——从后往前对比words频次 测试用例---");
        System.out.println(Arrays.toString(numSmallerByFrequency1(new String[] {"cbd"}, new String[] {"zaaaz"})));
        System.out.println(Arrays.toString(numSmallerByFrequency1(new String[] {"bbb", "cc"}, new String[] {"a", "aa",
                "aaa", "aaaa"})));

        System.out.println("--- 方法三：前缀和 测试用例---");
        System.out.println(Arrays.toString(numSmallerByFrequency2(new String[] {"cbd"}, new String[] {"zaaaz"})));
        System.out.println(Arrays.toString(numSmallerByFrequency2(new String[] {"bbb", "cc"}, new String[] {"a", "aa",
                "aaa", "aaaa"})));

        System.out.println("--- 方法四：二分法 测试用例---");
        System.out.println(Arrays.toString(numSmallerByFrequency3(new String[] {"cbd"}, new String[] {"zaaaz"})));
        System.out.println(Arrays.toString(numSmallerByFrequency3(new String[] {"bbb", "cc"}, new String[] {"a", "aa",
                "aaa", "aaaa"})));
    }

}

