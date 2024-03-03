package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00021Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mergeTwoLists(ListNode l1, ListNode l2, String expected) {
        ListNode result = new Solution00021().mergeTwoLists(l1, l2);

        if (expected == null) {
            assertThat(result).isNull();
        } else {
            assertThat(result)
                    .hasToString(expected);
        }
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 4),
                        ListNode.of(1, 3, 4),
                        "[1, 1, 2, 3, 4, 4]"),
                Arguments.of(ListNode.of(1, 2, 4),
                        null,
                        "[1, 2, 4]"),
                Arguments.of(null,
                        ListNode.of(1, 3, 4),
                        "[1, 3, 4]"),
                Arguments.of(null,
                        null,
                        null)
        );
    }

}