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
 * <p>
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * <p>
 * 思路：
 * 1. 预先写好一些私有方法
 * 1.1 添加元素到头结点
 * 1.2 删除指定节点
 * 1.3 删除尾节点
 * 1.4 移动节点到头结点（先删除节点，再添加到头结点）
 * 2. 查询元素
 * 2.1 如果不存在元素，返回特定值/抛出异常
 * 2.2 如果存在，将此节点移动到头结点，并返回其value值
 * 3. 添加/修改元素
 * 3.1 先在map中查询此元素是否存在
 * 3.2 不存在的情况
 * 3.2.1 先创建元素，并添加到头结点
 * 3.2.2 将节点在map中添加
 * 3.2.3 如果超过容量，删除尾节点，并删除map中尾节点的缓存
 * 3.3 存在的情况
 * 3.3.1 修改节点的元素值
 * 3.3.2 将此节点移动到头结点
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

