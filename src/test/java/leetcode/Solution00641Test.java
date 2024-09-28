package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution00641Test {

    /**
     * Explanation
     * MyCircularDeque myCircularDeque = new MyCircularDeque(3);
     * myCircularDeque.insertLast(1);  // return True
     * myCircularDeque.insertLast(2);  // return True
     * myCircularDeque.insertFront(3); // return True
     * myCircularDeque.insertFront(4); // return False, the queue is full.
     * myCircularDeque.getRear();      // return 2
     * myCircularDeque.isFull();       // return True
     * myCircularDeque.deleteLast();   // return True
     * myCircularDeque.insertFront(4); // return True
     * myCircularDeque.getFront();     // return 4
     */
    @Test
    void test1() {
        Solution00641.MyCircularDeque myCircularDeque = new Solution00641.MyCircularDeque(3);
        assertTrue(myCircularDeque.insertLast(1)); // return True
        assertTrue(myCircularDeque.insertLast(2)); // return True
        assertTrue(myCircularDeque.insertFront(3)); // return True
        assertFalse(myCircularDeque.insertFront(4)); // return False, the queue is full.
        assertEquals(2, myCircularDeque.getRear()); // return 2
        assertTrue(myCircularDeque.isFull()); // return True
        assertTrue(myCircularDeque.deleteLast()); // return True
        assertTrue(myCircularDeque.insertFront(4)); // return True
        assertEquals(4, myCircularDeque.getFront()); // return 4
    }

}