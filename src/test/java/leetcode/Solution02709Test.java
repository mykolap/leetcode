package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02709Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canTraverseAllPairs(int[] nums, boolean expected) {
        assertEquals(expected, new Solution02709().canTraverseAllPairs(nums));
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 6}, true),
                Arguments.of(new int[]{3, 9, 5}, false),
                Arguments.of(new int[]{4, 3, 12, 8}, true)
        );
    }

}