package design;

import java.util.LinkedHashMap;

/**
 * description:LRU缓存设计——借助Java数据结构实现
 *
 * @author RenShiWei
 * Date: 2021/12/2 17:18
 **/
public class LRUCacheAPI {

    int capacity;

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCacheAPI(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (! cache.containsKey(key)) {
            return - 1;
        }
        // 将 key 变为最近使⽤
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使⽤
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.capacity) {
            // 链表头部就是最久未使⽤的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插⼊到队尾
        cache.remove(key);
        cache.put(key, val);
    }

}

