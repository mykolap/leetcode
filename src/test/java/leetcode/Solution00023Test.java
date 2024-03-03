package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class Solution00023Test {

    static Object[][] casesProvider() {
        return new Object[][]{
                {
                        new ListNode[]{
                                ListNode.of(1, 4, 5),
                                ListNode.of(1, 3, 4),
                                ListNode.of(2, 6)
                        },
                        "[1, 1, 2, 3, 4, 4, 5, 6]"
                },
                {
                        new ListNode[]{
                                ListNode.of(1)
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
        ListNode actual = new Solution00023().mergeKLists(lists);
        if (expected == null) {
            assertNull(actual);
        } else {
            assertThat(actual).hasToString(expected);
        }
    }
}