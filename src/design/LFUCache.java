package design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * description:LFU缓存设计
 *
 * @author RenShiWei
 * Date: 2021/12/2 21:51
 **/
public class LFUCache {

    /** key 到 val 的映射，我们后文称为 KV 表 */
    Map<Integer, Integer> keyToVal;

    /** key 到 freq 的映射，我们后文称为 KF 表 */
    Map<Integer, Integer> keyToFreq;

    /** freq 到 key 列表的映射，我们后文称为 FK 表 */
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    /** 记录最小的频次 */
    int minFreq;

    /** 记录 LFU 缓存的最大容量 */
    int capacity;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    /**
     * 获取缓存值
     * 需要增加当前缓存的频次
     */
    public int get(int key) {
        if (! keyToVal.containsKey(key)) {
            return - 1;
        }
        // 增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    /**
     * 新增或修改缓存值
     * 1. 若 key 已存在，修改对应的 val
     * 2. key 不存在，需要插入
     * 3. 容量已满的话需要淘汰一个 freq 最小的 key
     */
    public void put(int key, int val) {
        if (this.capacity <= 0) {
            return;
        }

        /* 若 key 已存在，修改对应的 val 即可 */
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            // key 对应的 freq 加一
            increaseFreq(key);
            return;
        }

        /* key 不存在，需要插入 */
        /* 容量已满的话需要淘汰一个 freq 最小的 key */
        if (this.capacity <= keyToVal.size()) {
            removeMinFreqKey();
        }

        /* 插入 key 和 val，对应的 freq 为 1 */
        // 插入 KV 表
        keyToVal.put(key, val);
        // 插入 KF 表
        keyToFreq.put(key, 1);
        // 插入 FK 表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;
    }

    /**
     * 删除最小频次，并且最久未使用的key
     * 即LinkedHashSet的头结点
     */
    private void removeMinFreqKey() {
        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先被插入的那个 key 就是该被淘汰的 key
        int deletedKey = keyList.iterator().next();
        /* 更新 FK 表 */
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
            // 问：这里需要更新 minFreq 的值吗？
        }
        /* 更新 KV 表 */
        keyToVal.remove(deletedKey);
        /* 更新 KF 表 */
        keyToFreq.remove(deletedKey);
    }

    /**
     * 增加 key 对应的 freq
     */
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        /* 更新 KF 表 */
        keyToFreq.put(key, freq + 1);
        /* 更新 FK 表 */
        // 将 key 从 freq 对应的列表中删除
        freqToKeys.get(freq).remove(key);
        // 将 key 加入 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

}
