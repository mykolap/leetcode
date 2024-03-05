package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01750Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumLength(String s, int expected) {
        var result = new Solution01750().minimumLength(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("a", 1),
                Arguments.of("ca", 2),
                Arguments.of("aa", 0),
                Arguments.of("aaba", 1),
                Arguments.of("aba", 1),
                Arguments.of("abaa", 1),
                Arguments.of("aabca", 2),
                Arguments.of("cabaabac", 0),
                Arguments.of("aabccabba", 3)
        );
    }
}