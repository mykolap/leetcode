package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00007Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverse(int x, int expected) {
        int result = new Solution00007().reverse(x);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21),
                Arguments.of(0, 0),
                Arguments.of(1534236469, 0),
                Arguments.of(-2147483648, 0)
        );
    }

}