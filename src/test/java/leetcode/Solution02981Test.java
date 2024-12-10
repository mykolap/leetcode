package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02981Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumLength(String s, int expected) {
        int actual = new Solution02981().maximumLength(s);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aaaa", 2),
                Arguments.of("abcdef", -1),
                Arguments.of("abcaba", 1),
                Arguments.of("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde", 2)
        );
    }

}