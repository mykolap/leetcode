package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02220Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minBitFlips(int start, int goal, int expected) {
        int actual = new Solution02220().minBitFlips(start, goal);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(10, 7, 3),
                Arguments.of(3, 4, 3)
        );
    }

}