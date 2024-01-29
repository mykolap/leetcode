package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00232Test {

    @Test
    void testMyQueue() {
        Solution00232.MyQueue queue = new Solution00232.MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.pop()).isEqualTo(1);
        assertThat(queue.pop()).isEqualTo(2);
        assertThat(queue.pop()).isEqualTo(3);
        assertThat(queue.pop()).isEqualTo(4);
        assertThat(queue.empty()).isTrue();
    }

}