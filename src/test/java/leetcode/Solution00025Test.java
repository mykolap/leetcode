package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00025Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.arguments(ListNode.of(1, 2, 3, 4, 5), 2, "[2, 1, 4, 3, 5]"),
                Arguments.arguments(ListNode.of(1, 2, 3, 4, 5), 3, "[3, 2, 1, 4, 5]"),
                Arguments.arguments(ListNode.of(1, 2, 3, 4, 5), 1, "[1, 2, 3, 4, 5]"),
                Arguments.arguments(ListNode.of(1, 2, 3, 4, 5), 5, "[5, 4, 3, 2, 1]"),
                Arguments.arguments(ListNode.of(1), 1, "[1]"),
                Arguments.arguments(null, 1, null)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseKGroupRecursive(ListNode head, int k, String expected) {
        final ListNode actual = new Solution00025().reverseKGroupRecursive(head, k);
        if (expected == null) {
            assertThat(actual).isNull();
        } else {
            assertThat(actual).hasToString(expected);
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseKGroupIterative(ListNode head, int k, String expected) {
        final ListNode actual = new Solution00025().reverseKGroupIterative(head, k);
        if (expected == null) {
            assertThat(actual).isNull();
        } else {
            assertThat(actual).hasToString(expected);
        }
    }

}