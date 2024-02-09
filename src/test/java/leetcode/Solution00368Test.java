package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00368Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, List.of(1, 2)),
                Arguments.of(new int[]{1, 2, 4, 8}, List.of(1, 2, 4, 8)),
                Arguments.of(new int[]{4, 8, 10, 240}, List.of(4, 8, 240))
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void largestDivisibleSubset(int[] nums, List<Integer> expected) {
        assertThat(new Solution00368().largestDivisibleSubset(nums))
                .containsExactlyElementsOf(expected);
    }

}