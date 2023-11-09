package leetcode.generateParentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getGenerateParenthesisArgs() {
        return Stream.of(
                Arguments.of(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                Arguments.of(1, List.of("()"))
        );
    }

    @ParameterizedTest
    @MethodSource("getGenerateParenthesisArgs")
    void generateParenthesis(int n, List<String> expected) {
        assertEquals(expected, new Solution().generateParenthesis(n));
    }

    @ParameterizedTest
    @MethodSource("getGenerateParenthesisArgs")
    void generateParenthesisNonRecursive(int n, List<String> expected) {
        assertEquals(expected, new Solution().generateParenthesisNonRecursive(n));
    }

}