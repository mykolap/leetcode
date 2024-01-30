package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00704Test {

    static Stream<Arguments> getSearchArgs() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 11, -1),
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{1}, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("getSearchArgs")
    void search(int[] nums, int target, int expected) {
        assertEquals(expected, new Solution00704().search(nums, target));
    }

}