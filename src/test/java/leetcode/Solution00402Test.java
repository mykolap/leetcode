package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00402Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeKdigits(String num, int k, String expected) {
        String actual = new Solution00402().removeKdigits(num, k);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeKdigitsStack(String num, int k, String expected) {
        String actual = new Solution00402().removeKdigitsStack(num, k);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("1432219", 3, "1219"),
                Arguments.of("10200", 1, "200"),
                Arguments.of("10", 2, "0"),
                Arguments.of("9", 1, "0"),
                Arguments.of("1234567890", 9, "0")
        );
    }

}