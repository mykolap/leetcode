package leetcode.kthLargestElementInAStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0703Test {

    @Test
    void testOperations() {
        Solution0703.KthLargest kthLargest = new Solution0703.KthLargest(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }

}