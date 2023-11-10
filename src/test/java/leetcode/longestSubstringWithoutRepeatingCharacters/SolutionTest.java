package leetcode.longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getLengthOfLongestSubstringArgs() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("", 0),
                Arguments.of("dvdf", 3),
                Arguments.of("abba", 2),
                Arguments.of("tmmzuxt", 5),
                Arguments.of("ohvhjdml", 6),
                Arguments.of("abcabcbb", 3),
                Arguments.of("abcb", 3),
                Arguments.of("bbtablud", 6),
                Arguments.of("ckilbkd", 5),
                Arguments.of("aab", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("getLengthOfLongestSubstringArgs")
    void lengthOfLongestSubstring(String s, int expected) {
        int actual = new Solution().lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getLengthOfLongestSubstringArgs")
    void lengthOfLongestSubstringIntArr(String s, int expected) {
        int actual = new Solution().lengthOfLongestSubstringIntArr(s);
        assertEquals(expected, actual);
    }

}