package leetcode.coinChange;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void coinChange() {
        int[] coins = {1, 2, 5};
        int amount = 11;

        assertThat(new Solution().coinChange(coins, amount))
                .isEqualTo(3);
    }

}