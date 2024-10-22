package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02583Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void kthLargestLevelSum(String rootStr, int k, long expected) {
        Solution02583 solution02583 = new Solution02583();
        TreeNode root = TreeNode.of(rootStr);
        long actual = solution02583.kthLargestLevelSum(root, k);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,8,9,2,1,3,7,4,6]", 2, 13L),
                Arguments.of("[1,2,null,3]", 1, 3L)
        );
    }

}