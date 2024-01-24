package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01457Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of(2, 3, 1, 3, 1, null, 1), 2),
                Arguments.of(TreeNode.of(2, 1, 1, 1, 3, null, null, null, null, null, 1), 1),
                Arguments.of(TreeNode.of(9), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void pseudoPalindromicPaths(TreeNode root, int expected) {
        int actual = new Solution01457().pseudoPalindromicPaths(root);
        assertEquals(expected, actual);
    }

}