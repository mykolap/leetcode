package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00446Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 6, 8, 10}, 7),
                Arguments.of(new int[]{7, 7, 7, 7, 7}, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numberOfArithmeticSlices(int[] nums, int expected) {
        assertEquals(expected, new Solution00446().numberOfArithmeticSlices(nums));
    }

}