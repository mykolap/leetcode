package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00543Test {

    static Stream<Arguments> getArgsDiameterOrBinaryTree() {
        return Stream.of(
                Arguments.of(TreeNode.of("[1,2,3,4,5]"), 3),
                Arguments.of(TreeNode.of("[1,2]"), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgsDiameterOrBinaryTree")
    void diameterOfBinaryTreeRecursive(TreeNode root, int expected) {
        assertThat(new Solution00543().diameterOfBinaryTreeRecursive(root))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getArgsDiameterOrBinaryTree")
    void diameterOfBinaryTreeIterative(TreeNode root, int expected) {
        assertThat(new Solution00543().diameterOfBinaryTreeIterative(root))
                .isEqualTo(expected);
    }

}