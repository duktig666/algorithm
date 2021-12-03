package design;

import java.util.*;

/**
 * description: 380. O(1) 时间插入、删除和获取随机元素  @see https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 *
 * @author RenShiWei
 * Date: 2021/12/3 9:44
 **/
public class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> valToIndex;
    Random rand = new Random();

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    /**
     * 新增元素
     *
     * @return 如果存在，返回false；不存在插入后，返回true
     */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, nums.size());
        nums.add(nums.size(), val);
        return true;
    }

    /**
     * 删除元素
     * 1. 数组将删除元素的下标，设置为最后一个元素的值
     * 2. 删除最后数组最后一个元素
     * 3. 维护map中元素和索引的映射关系
     */
    public boolean remove(int val) {
        // 若 val 不存在，不⽤再删除
        if (! valToIndex.containsKey(val)) {
            return false;
        }
        // 最后一个元素
        int lastElement = nums.get(nums.size() - 1);
        // 当前删除元素的索引
        int index = valToIndex.get(val);

        // 待删除元素索引设置为最后一个元素
        nums.set(index, lastElement);
        // 修改map中最后一个元素的索引指向
        valToIndex.put(lastElement, index);

        // list中删除最后一个元素
        nums.remove(nums.size() - 1);
        // map中删除待删除元素的索引映射
        valToIndex.remove(val);

        return true;
    }

    /**
     * @return 等概率返回其中一个元素
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

}

