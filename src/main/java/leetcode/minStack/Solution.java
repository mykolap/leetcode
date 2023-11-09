package leetcode.minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/min-stack/
 * 155. Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * 1. MinStack() initializes the stack object.
 * 2. void push(val) pushes the element val onto the stack.
 * 3. void pop() removes the element on the top of the stack.
 * 4. int top() gets the top element of the stack.
 * 5. int getMin() retrieves the minimum element in the stack.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * // stack: [-2]
 * minStack.push(0);
 * // stack: [-2, 0]
 * minStack.push(-3);
 * // stack: [-2, 0, -3]
 * minStack.getMin(); // return -3
 * // stack: [-2, 0, -3]
 * minStack.pop();
 * // stack: [-2, 0]
 * minStack.top();    // return 0
 * // stack: [-2, 0]
 * minStack.getMin(); // return -2
 * // stack: [-2, 0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class Solution {

    static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public interface MinStack {
        void push(int val);

        void pop();

        int top();

        int getMin();
    }

    // Time: O(1)
    // Space: O(n)
    class MinStackImpl implements MinStack {

        private Node head;

        @Override
        public void push(int val) {
            if (head == null) {
                head = new Node(val, val, null);
            } else {
                head = new Node(val, Math.min(val, head.min), head);
            }
        }

        @Override
        public void pop() {
            head = head.next;
        }

        @Override
        public int top() {
            return head.val;
        }

        @Override
        public int getMin() {
            return head.min;
        }

    }

    class MinStackUsing2Deques implements MinStack {

        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStackUsing2Deques() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        @Override
        public void push(int val) {
            stack.push(val);

            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        @Override
        public void pop() {
            stack.pop();
            minStack.pop();
        }

        @Override
        public int top() {
            return stack.peek();
        }

        @Override
        public int getMin() {
            return minStack.peek();
        }

    }

}
