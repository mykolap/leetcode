package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00647Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abc", 3),
                Arguments.of("aaa", 6),
                Arguments.of("aaab", 7)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countSubstrings(String s, int expected) {
        assertEquals(expected, new Solution00647().countSubstrings(s));
    }

}