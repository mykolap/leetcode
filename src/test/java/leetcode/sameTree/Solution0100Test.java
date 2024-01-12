package leetcode.sameTree;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0100Test {

    static Stream<Arguments> getIsSameTreeArgs() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3), true),
                Arguments.of(TreeNode.of(1, 2), TreeNode.of(1, null, 2), false),
                Arguments.of(TreeNode.of(1, 2, 1), TreeNode.of(1, 1, 2), false)
        );
    }

    @ParameterizedTest
    @MethodSource("getIsSameTreeArgs")
    void isSameTree(TreeNode first, TreeNode second, boolean expected) {
        assertEquals(expected, new Solution0100().isSameTree(first, second));
    }

}