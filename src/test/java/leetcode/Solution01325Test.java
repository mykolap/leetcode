package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01325Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeLeafNodes(String treeStr, int target, String expectedStr) {
        final TreeNode root = TreeNode.of(treeStr);
        final TreeNode result = new Solution01325().removeLeafNodes(root, target);
        assertThat(result).hasToString(TreeNode.of(expectedStr).toString());
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,2,null,2,4]", 2,
                        "[1,null,3,null,4]"),
                Arguments.of("[1,3,3,3,2]", 3,
                        "[1,3,null,null,2]"),
                Arguments.of("[1,2,null,2,null,2]", 2,
                        "[1]")
        );
    }

}