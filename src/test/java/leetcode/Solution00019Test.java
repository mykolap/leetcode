package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00019Test {

    @Test
    void removeNthFromEnd() {
        ListNode head = ListNode.fromVarArgArray(1, 2, 3, 4, 5);

        new Solution00019().removeNthFromEnd(head, 2);

        assertThat(head)
                .hasToString("[1, 2, 3, 5]");
    }

    @Test
    void removeNthFromEnd_returnsCorrectOutput_forSingleNode() {
        ListNode head = new ListNode(1);

        ListNode result = new Solution00019().removeNthFromEnd(head, 1);

        assertThat(result).isNull();
    }

    @Test
    void removeNthFromEnd_returnsCorrectOutput_forTwoNodes() {
        ListNode head = ListNode.fromVarArgArray(1, 2);

        ListNode result = new Solution00019().removeNthFromEnd(head, 1);

        assertThat(result).hasToString("[1]");
    }

}