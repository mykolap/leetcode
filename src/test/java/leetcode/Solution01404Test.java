package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01404Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numSteps(String s, int expected) {
        int result = new Solution01404().numSteps(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("1101", 6),
                Arguments.of("10", 1),
                Arguments.of("1", 0),
                Arguments.of("1111110011101010110011100100101110010100101110111010111110110010", 89)
        );
    }

}