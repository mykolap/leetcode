package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01371Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findTheLongestSubstring(String s, int expected) {
        int actual = new Solution01371().findTheLongestSubstring(s);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return java.util.stream.Stream.of(
                Arguments.of("eleetminicoworoep", 13),
                Arguments.of("leetcodeisgreat", 5),
                Arguments.of("bcbcbc", 6),
                Arguments.of("id", 1)
        );
    }

}