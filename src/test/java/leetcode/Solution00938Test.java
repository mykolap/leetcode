package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00938Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of("[10,5,15,3,7,null,18]"),
                        7, 15,
                        32),
                Arguments.of(TreeNode.of("[10,5,15,3,7,13,18,1,null,6]"),
                        6, 10,
                        23)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rangeSumBstBfs(TreeNode root, int low, int high, int expected) {
        int actual = new Solution00938().rangeSumBstBfs(root, low, high);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rangeSumBstDfs(TreeNode root, int low, int high, int expected) {
        int actual = new Solution00938().rangeSumBstDfs(root, low, high);
        assertEquals(expected, actual);
    }
}