package leetcode.balancedBinaryTree;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0110Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        TreeNode.fromVarargArray(3, 9, 20, null, null, 15, 7),
                        true
                ),
                Arguments.of(
                        TreeNode.fromVarargArray(1, 2, 2, 3, 3, null, null, 4, 4),
                        false
                ),
                Arguments.of(
                        TreeNode.fromVarargArray(),
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isBalanced(TreeNode root, boolean expected) {
        boolean result = new Solution0110().isBalanced(root);
        assertEquals(expected, result);
    }
}