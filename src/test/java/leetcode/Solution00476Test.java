package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00476Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findComplement(int num, int expected) {
        int actual = new Solution00476().findComplement(num);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findComplementBinaryStr(int num, int expected) {
        int actual = new Solution00476().findComplementBinaryStr(num);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findComplementBitByBit(int num, int expected) {
        int actual = new Solution00476().findComplementBitByBit(num);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(1, 0)
        );
    }

}