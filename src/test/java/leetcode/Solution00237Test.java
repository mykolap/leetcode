package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00237Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void deleteNode(ListNode source, ListNode node, String expected) {
        Solution00237 solution = new Solution00237();
        solution.deleteNode(node);
        assertThat(source).hasToString(expected);
    }

    private static Stream<Arguments> casesProvider() {
        final ListNode sourceList1 = ListNode.of("[4,5,1,9]");
        final ListNode sourceList2 = ListNode.of("[4,5,1,9]");
        return Stream.of(
                Arguments.of(sourceList1, sourceList1.next, "[4,1,9]"),
                Arguments.of(sourceList2, sourceList2.next.next, "[4,5,9]")
        );
    }

}