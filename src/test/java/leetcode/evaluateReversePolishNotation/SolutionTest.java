package leetcode.evaluateReversePolishNotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getEvalRPNArgs() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("getEvalRPNArgs")
    void evalRPN(String[] tokens, int expected) {
        assertEquals(expected, new Solution().evalRPN(tokens));
    }

    @Test
    void evalRPN2() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int expected = 9;
        assertEquals(expected, new Solution().evalRPN2(tokens));
    }

}