package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00322Test {

    @Test
    void coinChange() {
        int[] coins = {1, 2, 5};
        int amount = 11;

        assertThat(new Solution00322().coinChange(coins, amount))
                .isEqualTo(3);
    }

}