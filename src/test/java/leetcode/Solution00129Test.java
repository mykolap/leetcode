package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00129Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumNumbers(TreeNode root, int expected) {
        int result = new Solution00129().sumNumbers(root);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of("[1,2,3]"), 25),
                Arguments.of(TreeNode.of("[4,9,0,5,1]"), 1026)
        );
    }
}