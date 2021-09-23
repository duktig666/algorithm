package beauty.serven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述：算法——非空子集
 * 编写一个方法，返回某集合的所有非空子集
 *
 * @author RenShiWei
 * Date: 2020/5/4 16:46
 **/
public class 非空子集 {

    public Set<Set<Integer>> getSubSets3 ( int[] arr, int n ) {
        return getSubSets3Core(arr, n, n - 1);
    }

    /**
     * 使用递归
     *
     * @param arr
     * @param n
     * @param cur
     * @return
     */
    private Set<Set<Integer>> getSubSets3Core ( int[] arr, int n, int cur ) {
        Set<Set<Integer>> newSet = new HashSet<>();
        if (cur == 0) {
            Set<Integer> nil = new HashSet<>();//空集
            Set<Integer> first = new HashSet<>();//包含第一个元素的集合
            first.add(arr[0]);
            newSet.add(nil);
            newSet.add(first);
            return newSet;
        }
        Set<Set<Integer>> oldSet = getSubSets3Core(arr, n, cur - 1);

        for (Set<Integer> set : oldSet) {
            //对每个子集，cur这个元素可以加进去，也可以不加进去
            newSet.add(set);//保留原样
            Set<Integer> clone = (Set<Integer>) ((HashSet) set).clone();
            clone.add(arr[cur]);//添加当前元素
            newSet.add(clone);
        }
        return newSet;
    }

    /**
     * 使用迭代
     *
     * @param arr
     * @param n
     * @return
     */
    public Set<Set<Integer>> getSubSets2 ( int[] arr, int n ) {
        Set<Set<Integer>> res = new HashSet<>();
        res.add(new HashSet<>());//初始化为空集
        //从第一个元素开始处理
        for (int i = 0; i < n; i++) {
            Set<Set<Integer>> newRes = new HashSet<>();
            newRes.addAll(res);
            //遍历之前的集合，对于当前元素可以加进去，或者布加进去
            for (Set set : res) {
                Set a = (Set) ((HashSet) set).clone();
                a.add(arr[i]);
                newRes.add(a);
            }
            res = newRes;
        }
        return res;
    }

    /**
     * 二进制解法（逆序排序）
     * 如果想正序排序，比较麻烦
     * @param arr
     * @param n
     * @return
     */
    public ArrayList<ArrayList<Integer>> getSubSets ( int[] arr, int n ) {
        //正序排序
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, n) - 1; i++) {
            //对每个i建立一个集合
            ArrayList<Integer> s = new ArrayList<>();
            //大数字-1，检查那个位上的二进制为1，从高位检查，高位对应数字靠后的元素
            for (int j = n - 1; j >= 0; j--) {
                if (((i >> j) & 1) == 1) {
                    s.add(arr[j]);
                }
            }
            res.add(s);
        }
        return res;
    }


}

