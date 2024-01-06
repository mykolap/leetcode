package leetcode.smallestMissingIntegerGreaterThanSequentialPrefixSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution10031Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 2, 5}, 6),
                Arguments.of(new int[]{8, 9, 10, 1, 2, 3, 2, 5}, 27),
                Arguments.of(new int[]{3, 4, 5, 1, 12, 14, 13}, 15),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 8, 9, 4, 3, 2, 7}, 30),
                Arguments.of(new int[]{46, 8, 2, 4, 1, 4, 10, 2, 4, 10, 2, 5, 7, 3, 1}, 47),
                Arguments.of(new int[]{37, 1, 2, 9, 5, 8, 5, 2, 9, 4}, 38)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void missingInteger(int[] ints, int expected) {
        final int actual = new Solution10031().missingInteger(ints);
        assertEquals(expected, actual);
    }

}