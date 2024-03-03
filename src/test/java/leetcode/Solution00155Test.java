package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00155Test {

    @Test
    void testMinStackImpl() {
        Solution00155.MinStackImpl minStack = new Solution00155().new MinStackImpl();

        testStack(minStack);
    }

    private static void testStack(Solution00155.MinStack minStackUsing2Deques) {
        minStackUsing2Deques.push(-2);
        // stack: [-2]
        minStackUsing2Deques.push(0);
        // stack: [-2, 0]
        minStackUsing2Deques.push(-3);
        // stack: [-2, 0, -3]
        assertEquals(-3, minStackUsing2Deques.getMin()); // return -3
        // stack: [-2, 0, -3]
        minStackUsing2Deques.pop();
        // stack: [-2, 0]
        assertEquals(0, minStackUsing2Deques.top());    // return 0
        // stack: [-2, 0]
        assertEquals(-2, minStackUsing2Deques.getMin()); // return -2
        // stack: [-2, 0]
    }

    @Test
    void testMinStackUsing2Dequeues() {
        Solution00155.MinStack minStackUsing2Deques = new Solution00155().new MinStackUsing2Deques();

        testStack(minStackUsing2Deques);
    }

}