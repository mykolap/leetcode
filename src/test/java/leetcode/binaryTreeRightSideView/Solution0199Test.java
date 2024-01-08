package leetcode.binaryTreeRightSideView;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution0199Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        null,
                        new int[]{}
                ),
                Arguments.of(
                        TreeNode.fromVarargArray(1, 2, 3, null, 5, null, 4),
                        new int[]{1, 3, 4}
                ),
                Arguments.of(
                        TreeNode.fromVarargArray(1, null, 3),
                        new int[]{1, 3}
                ),
                Arguments.of(
                        TreeNode.fromVarargArray(1, 2, 3, 4),
                        new int[]{1, 3, 4}
                ),
                Arguments.of(
                        TreeNode.fromVarargArray(1, 2, 3, 4, 5, 6, 7, 8, 9),
                        new int[]{1, 3, 7, 9}
                ),
                Arguments.of(
                        TreeNode.fromVarargArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
                        new int[]{1, 3, 7, 15}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rightSideViewBfs(TreeNode root, int[] expected) {
        int[] actual = new Solution0199().rightSideViewBfs(root).stream().mapToInt(i -> i).toArray();
        assertArrayEquals(expected, actual);
    }

}