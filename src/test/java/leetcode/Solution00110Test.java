package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00110Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(3, 9, 20, null, null, 15, 7),
                        true
                ),
                Arguments.of(
                        TreeNode.of(1, 2, 2, 3, 3, null, null, 4, 4),
                        false
                ),
                Arguments.of(
                        TreeNode.of(),
                        true
                ),
                Arguments.of(
                        TreeNode.of(1, 2, 2, 3, null, null, 3, 4, null, null, 4),
                        false
                ),
                Arguments.of(
                        TreeNode.of(1, 2, 3, 4, 5, 6, null, 8),
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isBalanced(TreeNode root, boolean expected) {
        boolean result = new Solution00110().isBalanced(root);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isBalancedOptimized(TreeNode root, boolean expected) {
        boolean result = new Solution00110().isBalancedOptimized(root);
        assertEquals(expected, result);
    }

}