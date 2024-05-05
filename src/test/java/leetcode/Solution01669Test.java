package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01669Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mergeInBetween(ListNode list1, int a, int b, ListNode list2, String expected) {
        ListNode result = new Solution01669().mergeInBetween(list1, a, b, list2);
        assertThat(result)
                .hasToString(expected);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        ListNode.of(10, 1, 13, 6, 9, 5),
                        3,
                        4,
                        ListNode.of(1000000, 1000001, 1000002),
                        "[10,1,13,1000000,1000001,1000002,5]"
                ),
                Arguments.of(
                        ListNode.of(0, 1, 2, 3, 4, 5, 6),
                        2,
                        5,
                        ListNode.of(1000000, 1000001, 1000002, 1000003, 1000004),
                        "[0,1,1000000,1000001,1000002,1000003,1000004,6]"
                )
        );
    }
}