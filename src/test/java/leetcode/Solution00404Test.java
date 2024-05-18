package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00404Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumOfLeftLeaves(String rootStr, int expected) {
        TreeNode root = TreeNode.of(rootStr);
        int result = new Solution00404().sumOfLeftLeaves(root);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        "[3,9,20,null,null,15,7]",
                        24
                ),
                Arguments.of(
                        "[1]",
                        0
                ),
                Arguments.of(
                        "[1,2,3,4,5]",
                        4
                ),
                Arguments.of(
                        "[1,2,3,4,5,6,7]",
                        10
                )
        );
    }
}