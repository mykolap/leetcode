package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00028Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void strStr(String haystack, String needle, int expected) {
        int result = new Solution00028().strStr(haystack, needle);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("hello", "ll", 2),
                Arguments.of("aaaaa", "bba", -1),
                Arguments.of("a", "a", 0),
                Arguments.of("a", "b", -1),
                Arguments.of("mississippi", "issip", 4),
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("leetcode", "leeto", -1)
        );
    }

}