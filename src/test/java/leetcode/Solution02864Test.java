package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02864Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumOddBinaryNumber(String s, String expected) {
        String result = new Solution02864().maximumOddBinaryNumber(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("01", "01"),
                Arguments.of("10", "01"),
                Arguments.of("010", "001"),
                Arguments.of("110", "101"),
                Arguments.of("0101", "1001"),
                Arguments.of("100100", "100001"),
                Arguments.of("100101", "110001")
        );
    }

}