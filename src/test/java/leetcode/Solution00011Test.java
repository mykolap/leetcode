package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00011Test {

    static Stream<Arguments> getMaxAreaArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{4, 3, 2, 1, 4}, 16),
                Arguments.of(new int[]{1, 2, 1}, 2),
                Arguments.of(new int[]{1, 2, 4, 3}, 4),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("getMaxAreaArgs")
    void maxArea(int[] height, int expected) {
        assertThat(new Solution00011().maxArea(height))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getMaxAreaArgs")
    void maxAreaBruteForce(int[] height, int expected) {
        assertThat(new Solution00011().maxArea(height))
                .isEqualTo(expected);
    }

}