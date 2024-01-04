package leetcode.lowestCommonAncestorOfABinarySearchTree;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0235Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.arguments(TreeNode.fromVarargArray(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                        2, 8, 6),
                Arguments.arguments(TreeNode.fromVarargArray(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                        2, 4, 2),
                Arguments.arguments(TreeNode.fromVarargArray(2, 1),
                        2, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lowestCommonAncestor(TreeNode root, int p, int q, int expected) {
        final TreeNode actual = new Solution0235().lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q));
        assertEquals(expected, actual.val);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lowestCommonAncestorOptimized(TreeNode root, int p, int q, int expected) {
        final TreeNode actual = new Solution0235().lowestCommonAncestorOptimized(root, new TreeNode(p), new TreeNode(q));
        assertEquals(expected, actual.val);
    }
}