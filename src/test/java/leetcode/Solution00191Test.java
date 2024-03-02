package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00191Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void hammingWeight(int n, int expected) {
        final int actual = new Solution00191().hammingWeight(n);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.arguments(0b00000000000000000000000000001011, 3),
                Arguments.arguments(0b00000000000000000000000010000000, 1),
                Arguments.arguments(0b11111111111111111111111111111101, 31)
        );
    }

}