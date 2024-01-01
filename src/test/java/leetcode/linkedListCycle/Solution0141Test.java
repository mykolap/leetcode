package leetcode.linkedListCycle;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution0141Test {

    static Stream<Arguments> casesProvider() {
        final ListNode example1 = ListNode.fromVarArgArray(3, 2, 0, -4);
        example1.next.next.next.next = example1.next;
        example1.safeToString = true;

        final ListNode example2 = ListNode.fromVarArgArray(1, 2);
        example2.next.next = example2;
        example2.safeToString = true;

        return Stream.of(
                Arguments.of(example1, true),
                Arguments.of(example2, true),
                Arguments.of(ListNode.fromVarArgArray(1), false),
                Arguments.of(ListNode.fromVarArgArray(1, 2, 3, 4, 5), false)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void hasCycle(ListNode head, boolean expected) {
        assertThat(new Solution0141().hasCycle(head)).isEqualTo(expected);
    }

}