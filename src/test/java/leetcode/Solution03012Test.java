package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03012Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 3, 1}, 1),
                Arguments.of(new int[]{5, 5, 5, 10, 5}, 2),
                Arguments.of(new int[]{2, 3, 4}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canSortArray(int[] nums, int expected) {
        int actual = new Solution03012().minimumArrayLength(nums);
        assertEquals(expected, actual);
    }
}