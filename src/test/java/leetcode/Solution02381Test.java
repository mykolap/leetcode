package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02381Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void shiftingLetters(String s, String shiftsStr, String expected) {
        int[][] shifts = ArrayUtils.stringToInt2DArray(shiftsStr);
        String actual = new Solution02381().shiftingLetters(s, shifts);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void shiftingLettersTle(String s, String shiftsStr, String expected) {
        int[][] shifts = ArrayUtils.stringToInt2DArray(shiftsStr);
        String actual = new Solution02381().shiftingLettersTle(s, shifts);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abc", "[[0,1,0],[1,2,1],[0,2,1]]", "ace"),
                Arguments.of("dztz", "[[0,0,0],[1,1,1]]", "catz")
        );
    }

}