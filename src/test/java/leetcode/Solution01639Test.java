package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01639Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numWays(String wordsStr, String target, int expected) {
        String[] words = ArrayUtils.stringToStringArray(wordsStr);
        assertEquals(expected, new Solution01639().numWays(words, target));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"acca\",\"bbbb\",\"caca\"]", "aba", 6),
                Arguments.of("[\"abba\",\"baab\"]", "bab", 4)
        );
    }

}