package leetcode;

import java.util.Arrays;

/**
 * 641. Design Circular Deque
 * <a href="https://leetcode.com/problems/design-circular-deque">Web link</a>
 * Medium
 */

public class Solution00641 {

    static class MyCircularDeque {

        private final int[] data;
        private int front;
        private int rear;
        private int size;

        public MyCircularDeque(int k) {
            data = new int[k];
            Arrays.fill(data, -1);
            front = 0;
            rear = 0;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + data.length) % data.length;
            data[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            data[rear] = value;
            rear = (rear + 1) % data.length;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % data.length;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + data.length) % data.length;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return data[front];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return data[(rear - 1 + data.length) % data.length];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == data.length;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

}