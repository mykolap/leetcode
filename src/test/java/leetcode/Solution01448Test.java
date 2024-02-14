package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01448Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of(3, 1, 4, 3, null, 1, 5), 4),
                Arguments.of(TreeNode.of(3, 3, null, 4, 2), 3),
                Arguments.of(TreeNode.of(1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void goodNodesDfs(TreeNode root, int expected) {
        int actual = new Solution01448().goodNodesDfs(root);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void goodNodesBfs(TreeNode root, int expected) {
        int actual = new Solution01448().goodNodesBfs(root);
        assertEquals(expected, actual);
    }

}