package leetcode.minimumWindowSubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getMinWindowArgs() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("a", "a", "a"),
                Arguments.of("a", "aa", ""),
                Arguments.of("aa", "aa", "aa")
        );
    }

    @ParameterizedTest
    @MethodSource("getMinWindowArgs")
    void minWindow(String s, String t, String expected) {
        assertEquals(expected, new Solution().minWindow(s, t));
    }

    @ParameterizedTest
    @MethodSource("getMinWindowArgs")
    void minWindowArr(String s, String t, String expected) {
        assertEquals(expected, new Solution().minWindowArr(s, t));
    }

}