package leetcode;

import leetcode.common.ArrayUtils;
import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02458Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    public void treeQueries(String rootStr, String queriesStr, String expected) {
        Solution02458 solution02458 = new Solution02458();
        TreeNode root = TreeNode.of(rootStr);
        int[] queries = ArrayUtils.stringToIntArray(queriesStr);
        var actual = solution02458.treeQueries(root, queries);
        assertEquals(expected, ArrayUtils.intArrayToString(actual));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3,4,2,null,6,5,null,null,null,null,null,7]", "[4]", "[2]"),
                Arguments.of("[5,8,9,2,1,3,7,4,6]", "[3,2,4,8]", "[3,2,3,2]")
        );
    }

}