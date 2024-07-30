package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01653Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumDeletions(String s, int expected) {
        assertEquals(expected, new Solution01653().minimumDeletions(s));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumDeletionsOptimized(String s, int expected) {
        assertEquals(expected, new Solution01653().minimumDeletionsOptimized(s));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aababbab", 2),
                Arguments.of("bbaaaaabb", 2)
        );
    }

}