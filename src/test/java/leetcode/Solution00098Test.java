package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00098Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of("[2,1,3]"), true),
                Arguments.of(TreeNode.of("[5,1,4,null,null,3,6]"), false),
                Arguments.of(TreeNode.of("[1,1]"), false),
                Arguments.of(TreeNode.of("[5,4,6,null,null,3,7]"), false),
                Arguments.of(TreeNode.of("[2147483647]"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isValidBstDfs(TreeNode root, boolean expected) {
        boolean actual = new Solution00098().isValidBstDfs(root);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isValidBstBfs(TreeNode root, boolean expected) {
        boolean actual = new Solution00098().isValidBstBfs(root);
        assertEquals(expected, actual);
    }

}