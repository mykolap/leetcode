package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00951Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void flipEquiv(String treeStr1, String treeStr2, boolean expected) {
        Solution00951 solution00951 = new Solution00951();
        TreeNode tree1 = TreeNode.of(treeStr1);
        TreeNode tree2 = TreeNode.of(treeStr2);
        boolean actual = solution00951.flipEquiv(tree1, tree2);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,4,5,6,null,null,null,7,8]", "[1,3,2,null,6,4,5,null,null,null,null,8,7]", true),
                Arguments.of("[]", "[]", true),
                Arguments.of("[]", "[1]", false)
        );
    }

}