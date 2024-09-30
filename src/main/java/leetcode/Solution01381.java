package leetcode;

/**
 * 1381. Design a Stack With Increment Operation
 * <a href="https://leetcode.com/problems/design-a-stack-with-increment-operation">Web link</a>
 * Medium
 */

public class Solution01381 {

    static class CustomStack {

        private final int[] data;
        private int top;

        public CustomStack(int maxSize) {
            data = new int[maxSize];
            top = -1;
        }

        public void push(int x) {
            if (top < data.length - 1) {
                data[++top] = x;
            }
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            return data[top--];
        }

        public void increment(int k, int val) {
            final int limit = Math.min(k, top + 1);
            for (int i = 0; i < limit; i++) {
                data[i] += val;
            }
        }

    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */