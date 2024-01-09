package leetcode.leafSimilarTrees;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0872Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.fromVarargArray(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
                        TreeNode.fromVarargArray(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8),
                        true),
                Arguments.of(TreeNode.fromVarargArray(1),
                        TreeNode.fromVarargArray(1),
                        true),
                Arguments.of(TreeNode.fromVarargArray(1),
                        TreeNode.fromVarargArray(2),
                        false),
                Arguments.of(TreeNode.fromVarargArray(1, 2),
                        TreeNode.fromVarargArray(2, 2),
                        true),
                Arguments.of(TreeNode.fromVarargArray(1, 2, 3),
                        TreeNode.fromVarargArray(1, 3, 2),
                        false)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void leafSimilarDfs(TreeNode root1, TreeNode root2, boolean expected) {
        boolean actual = new Solution0872().leafSimilarDfs(root1, root2);
        assertEquals(expected, actual);
    }
}