package leetcode;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01367Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isSubPath(String headStr, String rootStr, boolean expected) {
        ListNode head = ListNode.of(headStr);
        TreeNode root = TreeNode.of(rootStr);
        boolean actual = new Solution01367().isSubPath(head, root);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[4,2,8]", "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]", true),
                Arguments.of("[1,4,2,6]", "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]", true)
        );
    }

}