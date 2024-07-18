package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01530Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countPairs(String rootStr, int distance, int expected) {
        TreeNode root = TreeNode.of(rootStr);
        Solution01530 solution = new Solution01530();
        int result = solution.countPairs(root, distance);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,null,4]", 3, 1),
                Arguments.of("[1,2,3,4,5,6,7]", 3, 2),
                Arguments.of("[7,1,4,6,null,5,3,null,null,null,null,null,2]", 3, 1)
        );
    }

}