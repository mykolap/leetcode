package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00876Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void middleNode(ListNode head, ListNode expected) {
        ListNode actual = new Solution00876().middleNode(head);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(1), ListNode.of(1)),
                Arguments.of(ListNode.of(1, 2), ListNode.of(2)),
                Arguments.of(ListNode.of(1, 2, 3), ListNode.of(2, 3)),
                Arguments.of(ListNode.of(1, 2, 3, 4), ListNode.of(3, 4)),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), ListNode.of(3, 4, 5)),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5, 6), ListNode.of(4, 5, 6))
        );
    }

}