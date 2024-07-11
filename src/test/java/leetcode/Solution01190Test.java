package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01190Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseParentheses(String s, String expected) {
        String result = new Solution01190().reverseParentheses(s);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseParenthesesStackBased(String s, String expected) {
        String result = new Solution01190().reverseParenthesesStackBased(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("(abcd)", "dcba"),
                Arguments.of("(uoy evol I)", "I love you"),
                Arguments.of("(ed(et(oc))el)", "leetcode"),
                Arguments.of("a(bcdefghijkl(mno)p)q", "apmnolkjihgfedcbq")
        );
    }

}