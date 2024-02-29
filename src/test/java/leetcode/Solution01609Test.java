package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01609Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isEvenOddTree(TreeNode root, boolean expected) {
        boolean result = new Solution01609().isEvenOddTree(root);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2), true),
                Arguments.of(TreeNode.of(5, 4, 2, 3, 3, 7), false),
                Arguments.of(TreeNode.of(5, 9, 1, 3, 5, 7), false),
                Arguments.of(TreeNode.of(1), true)
        );
    }

}