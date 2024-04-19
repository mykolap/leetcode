package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00008Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void myAtoi(String s, int expected) {
        int result = new Solution00008().myAtoi(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("4193 with words", 4193),
                Arguments.of("words and 987", 0),
                Arguments.of("-91283472332", -2147483648),
                Arguments.of("91283472332", 2147483647),
                Arguments.of("3.14159", 3),
                Arguments.of("+-12", 0),
                Arguments.of("00000-42a1234", 0),
                Arguments.of("21474836460", 2147483647)
        );
    }

}