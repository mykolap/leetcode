package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00323Test {

    @Test
    void countComponents() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        assertThat(new Solution00323().countComponents(n, edges))
                .isEqualTo(2);
    }

}