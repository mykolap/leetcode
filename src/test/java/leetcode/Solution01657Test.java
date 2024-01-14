package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01657Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abc", "bca", true),
                Arguments.of("a", "aa", false),
                Arguments.of("cabbba", "abbccc", true),
                Arguments.of("cabbba", "aabbss", false)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void closeStrings(String word1, String word2, boolean expected) {
        assertEquals(expected, new Solution01657().closeStrings(word1, word2));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void closeStrings2(String word1, String word2, boolean expected) {
        assertEquals(expected, new Solution01657().closeStrings2(word1, word2));
    }

}