package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02182Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void repeatLimitedString(String s, int repeatLimit, String expected) {
        assertEquals(expected, new Solution02182().repeatLimitedString(s, repeatLimit));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("cczazcc", 3, "zzcccac"),
                Arguments.of("aababab", 2, "bbabaa")
        );
    }

}