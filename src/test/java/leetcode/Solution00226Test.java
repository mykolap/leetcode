package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00226Test {

    static Stream<Arguments> getInvertTreeArgs() {
        return Stream.of(
                Arguments.of(TreeNode.of(4, 2, 7, 1, 3, 6, 9), """
                               4       \s
                           7       2   \s
                         9   6   3   1 \s
                        """),
                Arguments.of(TreeNode.of(2, 1, 3), """
                           2   \s
                         3   1 \s
                        """),
                Arguments.of(TreeNode.of(1), " 1  \n")
        );
    }

    @ParameterizedTest
    @MethodSource("getInvertTreeArgs")
    void invertTree(TreeNode root, String expected) {
        assertThat(new Solution00226().invertTree(root))
                .hasToString(expected);
    }

    @ParameterizedTest
    @MethodSource("getInvertTreeArgs")
    void invertTreeIterative(TreeNode root, String expected) {
        assertThat(new Solution00226().invertTreeIterative(root))
                .hasToString(expected);
    }

    @Test
    void invertTreeNull() {
        TreeNode root = null;

        assertThat(new Solution00226().invertTree(root))
                .isNull();
    }

    @Test
    void invertTreeIterativeNull() {
        TreeNode root = null;

        assertThat(new Solution00226().invertTreeIterative(root))
                .isNull();
    }

}