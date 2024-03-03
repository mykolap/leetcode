package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00143Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reorderListEven(ListNode head, String expected) {
        new Solution00143().reorderList(head);

        assertEquals(expected, head.toString());
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4), "[1, 4, 2, 3]"),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), "[1, 5, 2, 4, 3]"),
                Arguments.of(new ListNode(1), "[1]")
        );
    }

}