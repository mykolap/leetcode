package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02337Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canChange(String start, String target, boolean expected) {
        boolean result = new Solution02337().canChange(start, target);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("_L__R__R_", "L______RR", true),
                Arguments.of("R_L_", "__LR", false),
                Arguments.of("_R", "R_", false)
        );
    }

}