package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01405Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestDiverseString(int a, int b, int c, String expected) {
        String result = new Solution01405().longestDiverseString(a, b, c);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(1, 1, 7, "ccaccbcc"),
                Arguments.of(2, 2, 1, "ababc"),
                Arguments.of(7, 1, 0, "aabaa")
        );
    }

}