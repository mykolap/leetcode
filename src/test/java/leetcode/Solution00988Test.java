package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00988Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void smallestFromLeaf(TreeNode root, String expected) {
        String result = new Solution00988().smallestFromLeaf(root);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of(0, 1, 2, 3, 4, 3, 4), "dba"),
                Arguments.of(TreeNode.of(25, 1, 3, 1, 3, 0, 2), "adz"),
                Arguments.of(TreeNode.of(2, 2, 1, null, 1, 0, null, 0), "abc"),
                Arguments.of(TreeNode.of(0, null, 1), "ba")
        );
    }

}