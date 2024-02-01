package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution02966Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2, new int[][]{{1, 1, 3}, {3, 4, 5}, {7, 8, 9}}),
                Arguments.of(new int[]{1, 3, 3, 2, 7, 3}, 3, new int[][]{})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void divideArray(int[] nums, int k, int[][] expected) {
        int[][] actual = new Solution02966().divideArray(nums, k);
        assertArrayEquals(expected, actual);
    }

}