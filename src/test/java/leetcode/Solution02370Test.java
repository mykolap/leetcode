package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02370Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestIdealString(String s, int k, int expected) {
        Solution02370 underTest = new Solution02370();
        assertEquals(expected, underTest.longestIdealString(s, k));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestIdealStringSimple(String s, int k, int expected) {
        Solution02370 underTest = new Solution02370();
        assertEquals(expected, underTest.longestIdealStringSimple(s, k));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("acfgbd", 2, 4),
                Arguments.of("abcd", 3, 4)
        );
    }

}