package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00124Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 2, 3), 6),
                Arguments.of(TreeNode.of(-10, 9, 20, null, null, 15, 7), 42),
                Arguments.of(TreeNode.of(-3), -3),
                Arguments.of(TreeNode.of(-2, -1), -1),
                Arguments.of(TreeNode.of(1, -2, 3), 4),
                Arguments.of(TreeNode.of(1, -2, -3, 1, 3, -2, null, -1), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxPathSum(TreeNode root, int expected) {
        assertEquals(expected, new Solution00124().maxPathSum(root));
    }

}