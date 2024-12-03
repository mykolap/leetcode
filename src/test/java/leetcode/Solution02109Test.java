package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02109Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void addSpaces(String s, String spacesStr, String expected) {
        int[] spaces = ArrayUtils.stringToIntArray(spacesStr);
        String result = new Solution02109().addSpaces(s, spaces);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("LeetcodeHelpsMeLearn", "8,13,15", "Leetcode Helps Me Learn"),
                Arguments.of("icodeinpython", "1,5,7,9", "i code in py thon"),
                Arguments.of("spacing", "0,1,2,3,4,5,6", " s p a c i n g")
        );
    }

}