package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00921Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minAddToMakeValid(String s, int expected) {
        int result = new Solution00921().minAddToMakeValid(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("())", 1),
                Arguments.of("(((", 3),
                Arguments.of("()", 0),
                Arguments.of("()))((", 4)
        );
    }

}