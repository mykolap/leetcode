package leetcode.maximumDepthOfBinaryTree;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution0104Test {

    static Stream<Arguments> getMaxDepthArgs() {
        return Stream.of(
                Arguments.of(TreeNode.fromVarargArray(3, 9, 20, null, null, 15, 7), 3),
                Arguments.of(TreeNode.fromVarargArray(1, null, 2), 2),
                Arguments.of(null, 0),
                Arguments.of(TreeNode.fromVarargArray(0), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getMaxDepthArgs")
    void maxDepth(TreeNode root, int expected) {
        assertThat(new Solution0104().maxDepth(root))
                .isEqualTo(expected);
    }

}