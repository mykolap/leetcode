package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02816Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void doubleIt(String headStr, String expected) {
        Solution02816 solution = new Solution02816();
        ListNode actual = solution.doubleIt(ListNode.of(headStr));
        assertThat(actual).hasToString(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,8,9]", "[3,7,8]"),
                Arguments.of("[9,9,9]", "[1,9,9,8]")
        );
    }

}