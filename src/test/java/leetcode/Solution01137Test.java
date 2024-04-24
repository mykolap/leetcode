package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01137Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void tribonacci(int n, int expected) {
        Solution01137 underTest = new Solution01137();
        assertEquals(expected, underTest.tribonacci(n));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(4, 4),
                Arguments.of(25, 1389537)
        );
    }

}