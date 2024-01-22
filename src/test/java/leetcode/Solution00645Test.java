package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00645Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 4}, new int[]{2, 3}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findErrorNums(int[] nums, int[] expected) {
        Solution00645 solution = new Solution00645();
        int[] actual = solution.findErrorNums(nums);
        assertArrayEquals(expected, actual);
    }

}