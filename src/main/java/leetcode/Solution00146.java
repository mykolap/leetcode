package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">
 * 146. LRU Cache
 * </a>
 * <br/>
 * <div class="content__u3I1 question-content__JfgR">
 * <div><p>Design a data structure that follows the constraints of a <a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU" target="_blank">Least Recently Used (LRU) cache</a>.</p>
 *
 * <p>Implement the <code>LRUCache</code> class:</p>
 *
 * <ul>
 * 	<li><code>LRUCache(int capacity)</code> Initialize the LRU cache with <em>positive</em> size <code>capacity</code>.</li>
 * 	<li><code>int get(int key)</code> Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li>
 * 	<li><code>void put(int key, int value)</code>&nbsp;Update the value of the <code>key</code> if the <code>key</code> exists. Otherwise, add the <code>key-value</code> pair to the cache. If the number of keys exceeds the <code>capacity</code> from this operation, <strong>evict</strong> the least recently used key.</li>
 * </ul>
 *
 * <p><strong>Follow up:</strong><br />
 * Could you do <code>get</code> and <code>put</code> in <code>O(1)</code> time complexity?</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * <strong>Output</strong>
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * <strong>Explanation</strong>
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= capacity &lt;= 3000</code></li>
 * 	<li><code>0 &lt;= key &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
 * 	<li>At most <code>2 * 10<sup>5</sup></code> calls will be made to <code>get</code> and <code>put</code>.</li>
 * </ul>
 * </div>
 * </div>
 */
public class Solution00146 {

    // Time: O(1)
    // Space: O(n)
    public static class LRUCache {

        private final int capacity;
        private final Map<Integer, Node> map;
        private final Node dummyMost;
        private final Node dummyLeast;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.dummyMost = new Node();
            this.dummyLeast = new Node();
            dummyMost.previous = dummyLeast;
            dummyLeast.next = dummyMost;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }

            remove(node);
            add(node);

            return node.value;
        }

        private void remove(Node node) {
            Node savedNext = node.next;
            Node savedPrevious = node.previous;
            savedNext.previous = savedPrevious;
            savedPrevious.next = savedNext;
        }

        private void add(Node node) {
            Node oldMost = dummyMost.previous;
            // link dummyMost to new most
            dummyMost.previous = node;
            node.next = dummyMost;
            // link current most to previous most
            node.previous = oldMost;
            oldMost.next = node;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                remove(node);
            } else if (map.size() == capacity) {
                final Node least = dummyLeast.next;
                remove(least);
                map.remove(least.key);
            }

            Node newMost = new Node(key, value);
            add(newMost);
            map.put(key, newMost);
        }

        private static class Node {

            private final int key;
            private int value;
            private Node previous;
            private Node next;

            public Node() {
                this.key = -1;
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

        }

    }
}
