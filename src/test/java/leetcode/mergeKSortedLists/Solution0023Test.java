package leetcode.mergeKSortedLists;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class Solution0023Test {

    static Object[][] casesProvider() {
        return new Object[][]{
                {
                        new ListNode[]{
                                ListNode.fromVarArgArray(1, 4, 5),
                                ListNode.fromVarArgArray(1, 3, 4),
                                ListNode.fromVarArgArray(2, 6)
                        },
                        "[1, 1, 2, 3, 4, 4, 5, 6]"
                },
                {
                        new ListNode[]{
                                ListNode.fromVarArgArray(1)
                        },
                        "[1]"
                },
                {
                        new ListNode[]{
                        },
                        null
                }
        };
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mergeKLists(ListNode[] lists, String expected) {
        ListNode actual = new Solution0023().mergeKLists(lists);
        if (expected == null) {
            assertNull(actual);
        } else {
            assertThat(actual).hasToString(expected);
        }
    }
}