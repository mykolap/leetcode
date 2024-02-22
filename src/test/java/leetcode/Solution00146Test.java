package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00146Test {

    @Test
    void testOperations() {
        Solution00146.LRUCache cache = new Solution00146.LRUCache(2);
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        assertEquals(1, cache.get(1));    // return 1
        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertEquals(-1, cache.get(2));    // returns -1 (not found)
        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertEquals(-1, cache.get(1));    // return -1 (not found)
        assertEquals(3, cache.get(3));    // return 3
        assertEquals(4, cache.get(4));    // return 4
    }

    @Test
    void testOperations2() {
        Solution00146.LRUCache cache = new Solution00146.LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        assertEquals(2, cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        assertEquals(-1, cache.get(2));
    }

}