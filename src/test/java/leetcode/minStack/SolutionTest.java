package leetcode.minStack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testMinStackImpl() {
        Solution.MinStackImpl minStack = new Solution().new MinStackImpl();

        testStack(minStack);
    }

    private static void testStack(Solution.MinStack minStackUsing2Deques) {
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
        Solution.MinStack minStackUsing2Deques = new Solution().new MinStackUsing2Deques();

        testStack(minStackUsing2Deques);
    }

}