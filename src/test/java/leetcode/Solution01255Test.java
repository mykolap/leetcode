package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01255Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxScoreWords(String wordsStr, String lettersStr, String scoreStr, int expected) {
        String[] words = ArrayUtils.stringToStringArray(wordsStr);
        char[] letters = ArrayUtils.stringToCharArray(lettersStr);
        int[] score = ArrayUtils.stringToIntArray(scoreStr);
        int result = new Solution01255().maxScoreWords(words, letters, score);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"dog\",\"cat\",\"dad\",\"good\"]",
                        "\"a\",\"a\",\"c\",\"d\",\"d\",\"d\",\"g\",\"o\",\"o\"",
                        "[1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]",
                        23),
                Arguments.of("[\"xxxz\",\"ax\",\"bx\",\"cx\"]",
                        "\"z\",\"a\",\"b\",\"c\",\"x\",\"x\",\"x\"",
                        "[4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]",
                        27),
                Arguments.of("[\"leetcode\"]",
                        "\"l\",\"e\",\"t\",\"c\",\"o\",\"d\"",
                        "[0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0]",
                        0)
        );
    }

}