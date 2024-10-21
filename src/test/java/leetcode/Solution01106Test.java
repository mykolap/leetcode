package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01106Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void parseBoolExpr(String expression, boolean expected) {
        boolean actual = new Solution01106().parseBoolExpr(expression);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("&(|(f))", false),
                Arguments.of("|(f,f,f,t)", true),
                Arguments.of("!(&(f,t))", true)
        );
    }

}