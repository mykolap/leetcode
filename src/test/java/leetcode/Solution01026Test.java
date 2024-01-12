package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01026Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13), 7),
                Arguments.of(TreeNode.of(1, null, 2, null, 0, 3), 3),
                Arguments.of(TreeNode.of(1, 2, 0, 3, 4), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxAncestorDiffDfs(TreeNode root, int expected) {
        int actual = new Solution01026().maxAncestorDiffDfs(root);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxAncestorDiffBfs(TreeNode root, int expected) {
        int actual = new Solution01026().maxAncestorDiffBfs(root);
        assertEquals(expected, actual);
    }

}