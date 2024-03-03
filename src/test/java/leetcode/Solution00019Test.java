package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00019Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeNthFromEnd(ListNode head, int n, String expected) {
        var result = new Solution00019().removeNthFromEnd(head, n);

        if (expected == null) {
            assertThat(result).isNull();
        } else {
            assertThat(result)
                    .hasToString(expected);
        }
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 2, "[1, 2, 3, 5]"),
                Arguments.of(ListNode.of(1), 1, null),
                Arguments.of(ListNode.of(1, 2), 1, "[1]"),
                Arguments.of(ListNode.of(1, 2), 2, "[2]")
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeNthFromEndAlt(ListNode head, int n, String expected) {
        var result = new Solution00019().removeNthFromEndAlt(head, n);

        if (expected == null) {
            assertThat(result).isNull();
        } else {
            assertThat(result)
                    .hasToString(expected);
        }
    }

}