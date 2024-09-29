package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00432Test {

    /**
     * Explanation
     * AllOne allOne = new AllOne();
     * allOne.inc("hello");
     * allOne.inc("hello");
     * allOne.getMaxKey(); // return "hello"
     * allOne.getMinKey(); // return "hello"
     * allOne.inc("leet");
     * allOne.getMaxKey(); // return "hello"
     * allOne.getMinKey(); // return "leet"
     */
    @Test
    void test1() {
        Solution00432.AllOne allOne = new Solution00432.AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        assertEquals("hello", allOne.getMaxKey());
        assertEquals("hello", allOne.getMinKey());
        allOne.inc("leet");
        assertEquals("hello", allOne.getMaxKey());
        assertEquals("leet", allOne.getMinKey());
    }

}