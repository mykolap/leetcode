package leetcode.jumpGameIi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0045Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{1, 1, 1, 1}, 3),
                Arguments.of(new int[]{2, 1, 0, 1, 4}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void jumpRecursive(int[] nums, int expected) {
        int actual = new Solution0045().jumpRecursive(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void jumpGreedy(int[] nums, int expected) {
        int actual = new Solution0045().jumpGreedy(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void jumpDp(int[] nums, int expected) {
        int actual = new Solution0045().jumpDp(nums);
        assertEquals(expected, actual);
    }

}