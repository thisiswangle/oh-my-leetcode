package s146_lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class ListNode {
        ListNode pre;
        ListNode next;
        int key;
        int val;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class LRUList {
        private ListNode headSentry = new ListNode(-1, -1);
        private ListNode tailSentry = new ListNode(-1, -1);
        public LRUList() {
            headSentry.next = tailSentry;
            tailSentry.pre = headSentry;
        }
        public void insertToHead(ListNode node) {
            headSentry.next.pre = node;
            node.next = headSentry.next;
            node.pre = headSentry;
            headSentry.next = node;
        }

        public ListNode removeFromTail() {
            ListNode node = tailSentry.pre;
            node.pre.next = tailSentry;
            tailSentry.pre = node.pre;
            return node;
        }

        public void moveToHead(ListNode node) {
            // Remove current position
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;

            // Insert to head
            insertToHead(node);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            ListNode node = headSentry.next;
            while (node.next != null) {
                sb.append(String.format("%d:%d,", node.key, node.val));
                node = node.next;
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private int capacity;
    private int size = 0;
    private LRUList list = new LRUList();

    // Keep a index for all values
    private Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null)
            return -1;
        else {
            list.moveToHead(node);
            return node.val;
        }
    }

    public void set(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            if (size == capacity) {
                ListNode rmNode = list.removeFromTail();
                map.remove(rmNode.key);

                ListNode newNode = new ListNode(key, value);
                list.insertToHead(newNode);
                map.put(key, newNode);
            } else if (size < capacity) {
                size ++;
                ListNode newNode = new ListNode(key, value);
                list.insertToHead(newNode);
                map.put(key, newNode);
            }
        } else {
            node.val = value;
            list.moveToHead(node);
        }
    }
    @Override
    public String toString() {
        return list.toString();
    }
}
