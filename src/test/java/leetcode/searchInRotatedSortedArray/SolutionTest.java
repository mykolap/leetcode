package leetcode.searchInRotatedSortedArray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getSearchArgs() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{1}, 1, 0),
                Arguments.of(new int[]{}, 5, -1),
                Arguments.of(new int[]{3}, 5, -1),
                Arguments.of(new int[]{5}, 5, 0),
                Arguments.of(new int[]{3, 1}, 3, 0),
                Arguments.of(new int[]{3, 1}, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getSearchArgs")
    void searchInRotatedArray(int[] nums, int target, int expected) {
        assertEquals(expected, new Solution().search(nums, target));
    }

}