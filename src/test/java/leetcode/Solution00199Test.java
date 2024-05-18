package leetcode;

import leetcode.common.ArrayUtils;
import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00199Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        null,
                        ""),
                Arguments.of(
                        "[1,2,3,null,5,null,4]",
                        "[1,3,4]"),
                Arguments.of("[1,null,3]",
                        "[1,3]"),
                Arguments.of(
                        "[1,2,3,4]",
                        "[1,3,4]"),
                Arguments.of(
                        "[1,2,3,4,5,6,7,8,9]",
                        "[1,3,7,9]"),
                Arguments.of(
                        "[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]",
                        "[1,3,7,15]")
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rightSideViewBfs(String rootStr, String expectedStr) {
        TreeNode root = TreeNode.of(rootStr);
        int[] actual = new Solution00199().rightSideViewBfs(root).stream().mapToInt(i -> i).toArray();
        int[] expected = ArrayUtils.stringToIntArray(expectedStr);
        assertArrayEquals(expected, actual);
    }

}