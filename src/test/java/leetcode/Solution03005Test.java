package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03005Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxFrequencyElements(int[] nums, int expected) {
        int actual = new Solution03005().maxFrequencyElements(nums);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 1, 4}, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{1, 1, 100}, 2),
                Arguments.of(new int[]{1, 1, 100, 100}, 4),
                Arguments.of(new int[]{100, 1}, 2),
                Arguments.of(new int[]{15}, 1)
        );
    }
}