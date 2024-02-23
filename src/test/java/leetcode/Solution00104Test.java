package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00104Test {

    static Stream<Arguments> getMaxDepthArgs() {
        return Stream.of(
                Arguments.of(TreeNode.of(3, 9, 20, null, null, 15, 7), 3),
                Arguments.of(TreeNode.of(1, null, 2), 2),
                Arguments.of(null, 0),
                Arguments.of(TreeNode.of(0), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getMaxDepthArgs")
    void maxDepthRecursiveDfs(TreeNode root, int expected) {
        assertThat(new Solution00104().maxDepthRecursiveDfs(root))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getMaxDepthArgs")
    void maxDepthIterativeBfs(TreeNode root, int expected) {
        assertThat(new Solution00104().maxDepthIterativeBfs(root))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getMaxDepthArgs")
    void maxDepthIterativeDfs(TreeNode root, int expected) {
        assertThat(new Solution00104().maxDepthIterativeDfs(root))
                .isEqualTo(expected);
    }

}