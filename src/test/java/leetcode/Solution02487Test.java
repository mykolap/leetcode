package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02487Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeNodes(String headStr, String expected) {
        Solution02487 solution = new Solution02487();
        ListNode actual = solution.removeNodes(ListNode.of(headStr));
        assertThat(actual).hasToString(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,2,13,3,8]", "[13,8]"),
                Arguments.of("[1,1,1,1]", "[1,1,1,1]")
        );
    }

}