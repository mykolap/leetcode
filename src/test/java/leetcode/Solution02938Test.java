package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02938Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumSteps(String s, long expected) {
        long result = new Solution02938().minimumSteps(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("101", 1),
                Arguments.of("100", 2),
                Arguments.of("0111", 0)
        );
    }

}