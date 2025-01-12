package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02116Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canBeValid(String s, String locked, boolean expected) {
        boolean result = new Solution02116().canBeValid(s, locked);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("))()))", "010100", true),
                Arguments.of("()()", "0000", true),
                Arguments.of(")", "0", false)
        );
    }

}