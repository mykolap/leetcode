package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00131Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void partition(String s, String expected) {
        assertEquals(expected, new Solution00131().partition(s).toString());
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aab", "[[a, a, b], [aa, b]]"),
                Arguments.of("a", "[[a]]")
        );
    }

}