package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. All O`one Data Structure
 * <a href="https://leetcode.com/problems/all-oone-data-structure">Web link</a>
 * Hard
 */

public class Solution00432 {

    static class AllOne {

        private final Node head;
        private final Node tail;
        private final Map<String, Node> map;

        public AllOne() {
            head = new Node(0);
            tail = new Node(0);
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public void inc(String key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                int freq = node.freq;
                node.keys.remove(key);

                Node nextNode = node.next;
                if (nextNode == tail || nextNode.freq != freq + 1) {
                    Node newNode = new Node(freq + 1);
                    newNode.keys.add(key);
                    newNode.prev = node;
                    newNode.next = nextNode;
                    node.next = newNode;
                    nextNode.prev = newNode;
                    map.put(key, newNode);
                } else {
                    nextNode.keys.add(key);
                    map.put(key, nextNode);
                }
                if (node.keys.isEmpty()) {
                    deleteNode(node);
                }
            } else {
                Node firstNode = head.next;
                if (firstNode == tail || firstNode.freq > 1) {
                    Node newNode = new Node(1);
                    newNode.keys.add(key);
                    newNode.prev = head;
                    newNode.next = firstNode;
                    head.next = newNode;
                    firstNode.prev = newNode;
                    map.put(key, newNode);
                } else {
                    firstNode.keys.add(key);
                    map.put(key, firstNode);
                }
            }
        }

        public void dec(String key) {
            if (!map.containsKey(key)) {
                return;
            }
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);

            if (freq > 1) {
                Node prevNode = node.prev;
                if (prevNode == head || prevNode.freq != freq - 1) {
                    Node newNode = new Node(freq - 1);
                    newNode.keys.add(key);
                    newNode.prev = prevNode;
                    newNode.next = node;
                    node.prev = newNode;
                    prevNode.next = newNode;
                    map.put(key, newNode);
                } else {
                    prevNode.keys.add(key);
                    map.put(key, prevNode);
                }
            } else {
                map.remove(key);
            }
            if (node.keys.isEmpty()) {
                deleteNode(node);
            }
        }

        public String getMaxKey() {
            if (tail.prev == head) {
                return "";
            }
            return tail.prev.keys.iterator().next();
        }

        public String getMinKey() {
            if (head.next == tail) {
                return "";
            }
            return head.next.keys.iterator().next();
        }

        private void deleteNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

    }

    private static class Node {
        private final int freq;
        private Node prev;
        private Node next;
        private final Set<String> keys;

        public Node(int freq) {
            this.freq = freq;
            this.keys = new HashSet<>();
        }
    }

}