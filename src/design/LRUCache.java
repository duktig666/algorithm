package design;

import java.util.HashMap;
import java.util.Map;

/**
 * description:LRU缓存设计——自定义实现
 * <p>
 * 默认从链表尾部添加元素，靠近尾部为最近使用的，靠近头部是最久未使用的
 *
 * @author RenShiWei
 * Date: 2021/12/2 15:55
 **/
public class LRUCache<K, V> {

    /** key -> Node(key, val) */
    private Map<K, Node<K, V>> map;

    /** Node(k1, v1) <-> Node(k2, v2)... */
    private DoubleList<K, V> cache;

    /** 最大容量 */
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList<>();
    }

    /**
     * 将某个 key 提升为最近使⽤的
     */
    private void makeRecently(K key) {
        Node<K, V> x = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
    }

    /**
     * 添加最近使⽤的元素
     */
    private void addRecently(K key, V val) {
        Node<K, V> node = new Node<>(key, val);
        // 链表尾部就是最近使⽤的元素
        cache.addLast(node);
        // 别忘了在 map 中添加 key 的映射
        map.put(key, node);
    }

    /**
     * 删除某⼀个 key
     */
    private void deleteKey(K key) {
        Node<K, V> node = map.get(key);
        // 从链表中删除
        cache.remove(node);
        // 从 map 中删除
        map.remove(key);
    }

    /**
     * 删除最久未使⽤的元素
     */
    private void removeLeastRecently() {
        // 链表头部的第⼀个元素就是最久未使⽤的
        Node<K, V> deletedNode = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        K deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    /**
     * 从缓存中取值，并将当前的值设为最近使用过的
     */
    public V get(K key) {
        if (! map.containsKey(key)) {
            return null;
        }
        // 将该数据提升为最近使⽤的
        this.makeRecently(key);
        return map.get(key).val;
    }

    /**
     * 往缓存添加数据
     * 如果存在删除旧数据，将新数据添加到链表尾部
     * 如果达到容量，删除头部的元素，新元素添加到尾部
     */
    public void put(K key, V val) {
        if (map.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            // 新插⼊的数据为最近使⽤的数据
            addRecently(key, val);
            return;
        }

        if (cache.size() >= capacity) {
            // 删除最久未使⽤的元素
            this.removeLeastRecently();
        }
        // 添加为最近使⽤的元素
        addRecently(key, val);
    }


    /**
     * 双向链表的节点
     */
    private static class Node<K, V> {
        K key;
        V val;
        Node<K, V> next, prev;

        public Node(K k, V v) {
            this.key = k;
            this.val = v;
        }
    }

    /**
     * 双向链表
     */
    private static class DoubleList<K, V> {
        // 头尾虚节点
        private Node<K, V> head, tail;
        // 链表元素数
        private int size;

        /**
         * 初始化双向链表的数据
         */
        public DoubleList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /**
         * 在链表尾部添加节点 node，时间 O(1)
         */
        public void addLast(Node<K, V> node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        /**
         * 删除链表中的 node 节点（node ⼀定存在）
         * 由于是双链表且给的是⽬标 Node 节点，时间 O(1)
         */
        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        /**
         * 删除链表中第⼀个节点，并返回该节点，时间 O(1)
         *
         * @return del node
         */
        public Node<K, V> removeFirst() {
            // 如果只有一个节点，直接返回null
            if (head.next == tail) {
                return null;
            }
            Node<K, V> first = head.next;
            this.remove(first);
            return first;
        }

        /**
         * 返回链表⻓度，时间 O(1)
         */
        public int size() { return size; }

    }

}

