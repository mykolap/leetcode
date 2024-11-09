package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03133Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minEnd(int n, int x, long expected) {
        long result = new Solution03133().minEnd(n, x);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, 4, 6L),
                Arguments.of(2, 7, 15L)
        );
    }

}