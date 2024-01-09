package leetcode.validateBinarySearchTree;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0098Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.fromVarargArray(2, 1, 3), true),
                Arguments.of(TreeNode.fromVarargArray(5, 1, 4, null, null, 3, 6), false),
                Arguments.of(TreeNode.fromVarargArray(1, 1), false),
                Arguments.of(TreeNode.fromVarargArray(5, 4, 6, null, null, 3, 7), false),
                Arguments.of(TreeNode.fromVarargArray(2147483647), true)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isValidBstDfs(TreeNode root, boolean expected) {
        boolean actual = new Solution0098().isValidBstDfs(root);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isValidBstBfs(TreeNode root, boolean expected) {
        boolean actual = new Solution0098().isValidBstBfs(root);
        assertEquals(expected, actual);
    }

}