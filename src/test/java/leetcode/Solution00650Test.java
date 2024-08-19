package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00650Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minSteps(int expected, int n) {
        assertEquals(expected, new Solution00650().minSteps(n));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, 3),
                Arguments.of(0, 1)
        );
    }

}