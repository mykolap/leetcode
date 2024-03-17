package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00006Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void convert(String s, int numRows, String expected) {
        String result = new Solution00006().convert(s, numRows);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void convertArr(String s, int numRows, String expected) {
        String result = new Solution00006().convertArr(s, numRows);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return java.util.stream.Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A")
        );
    }
}