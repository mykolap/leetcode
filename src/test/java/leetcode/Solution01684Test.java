package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01684Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countConsistentStrings(String allowed, String[] words, int expected) {
        int actual = new Solution01684().countConsistentStrings(allowed, words);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}, 2),
                Arguments.of("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}, 7),
                Arguments.of("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}, 4)
        );
    }

}