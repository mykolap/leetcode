package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00230Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of("[3,1,4,null,2]"), 1, 1),
                Arguments.of(TreeNode.of("[5,3,6,2,4,null,null,1]"), 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void kthSmallestRecursive(TreeNode root, int k, int expected) {
        int result = new Solution00230().kthSmallestRecursive(root, k);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void kthSmallestIterative(TreeNode root, int k, int expected) {
        int result = new Solution00230().kthSmallestIterative(root, k);
        assertEquals(expected, result);
    }

}