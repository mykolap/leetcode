package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01381Test {

    /**
     * Explanation
     * CustomStack stk = new CustomStack(3); // Stack is Empty []
     * stk.push(1);                          // stack becomes [1]
     * stk.push(2);                          // stack becomes [1, 2]
     * stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
     * stk.push(2);                          // stack becomes [1, 2]
     * stk.push(3);                          // stack becomes [1, 2, 3]
     * stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
     * stk.increment(5, 100);                // stack becomes [101, 102, 103]
     * stk.increment(2, 100);                // stack becomes [201, 202, 103]
     * stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
     * stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
     * stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
     * stk.pop();                            // return -1 --> Stack is empty return -1.
     */
    @Test
    void test1() {
        Solution01381.CustomStack stk = new Solution01381.CustomStack(3);
        stk.push(1);
        stk.push(2);
        assertEquals(2, stk.pop());
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.increment(5, 100);
        stk.increment(2, 100);
        assertEquals(103, stk.pop());
        assertEquals(202, stk.pop());
        assertEquals(201, stk.pop());
        assertEquals(-1, stk.pop());
    }

}