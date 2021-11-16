package leetcode.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * description: LRUCache 146 @see https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 设计 最近最少使用 缓存机制
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * @author RenShiWei
 * Date: 2021/11/9 20:55
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 * <p>
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 **/
public class LRUCache {

    private static class DoubleLinkedNode {
        int k;
        int v;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        DoubleLinkedNode() {}

        DoubleLinkedNode(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private Map<Object, DoubleLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return - 1;
        }
        this.moveToHead(node);
        return node.v;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果没有当前元素，新创建
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            cache.put(key, newNode);
            this.addToHead(newNode);
            ++ size;
            if (size > capacity) {
                DoubleLinkedNode tail = this.removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.k);
                -- size;
            }
        } else {
            node.v = value;
            moveToHead(node);
        }

    }

    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode res = tail.prev;
        this.removeNode(res);
        return res;
    }


    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addToHead(node);
    }

    private void addToHead(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}

