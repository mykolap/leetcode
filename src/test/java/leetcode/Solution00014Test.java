package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00014Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestCommonPrefix(String[] strs, String expected) {
        String result = new Solution00014().longestCommonPrefix(strs);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
                Arguments.of(new String[]{"", "b"}, ""),
                Arguments.of(new String[]{"a"}, "a")
        );
    }

}