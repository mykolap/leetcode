package leetcode.subtreeOfAnotherTree;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution0572Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(3, 4, 5, 1, 2),
                        TreeNode.of(4, 1, 2),
                        true
                ),
                Arguments.of(
                        TreeNode.of(3, 4, 5, 1, 2, null, null, null, null, 0),
                        TreeNode.of(4, 1, 2),
                        false
                ),
                Arguments.of(
                        TreeNode.of(1, 1),
                        TreeNode.of(1),
                        true
                ),
                Arguments.of(
                        null,
                        TreeNode.of(1),
                        false
                ),
                Arguments.of(
                        TreeNode.of(1),
                        null,
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isSubtreeDfsRecursive(TreeNode root, TreeNode subRoot, boolean expected) {
        assertThat(new Solution0572().isSubtreeDfsRecursive(root, subRoot))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isSubtreeBfsIterative(TreeNode root, TreeNode subRoot, boolean expected) {
        assertThat(new Solution0572().isSubtreeBfsIterative(root, subRoot))
                .isEqualTo(expected);
    }
}