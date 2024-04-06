package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01249Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minRemoveToMakeValid(String s, String expected) {
        String result = new Solution01249().minRemoveToMakeValid(s);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minRemoveToMakeValidStack(String s, String expected) {
        String result = new Solution01249().minRemoveToMakeValidStack(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("lee(t(c)o)de)", "lee(t(c)o)de"),
                Arguments.of("a)b(c)d", "ab(c)d"),
                Arguments.of("))((", ""),
                Arguments.of("((a)((b)", "((a)b)"),
                Arguments.of("(((a))(((b))", "(((a))(b))")
        );
    }
}