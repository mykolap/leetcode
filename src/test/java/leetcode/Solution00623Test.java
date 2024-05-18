package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00623Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void addOneRow(TreeNode root, int v, int d, TreeNode expected) {
        TreeNode result = new Solution00623().addOneRow(root, v, d);
        assertThat(result).hasToString(expected.toString());
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of("[4,2,6,3,1,5]"),
                        1,
                        2,
                        TreeNode.of("[4,1,1,2,null,null,6,3,1,5]")),
                Arguments.of(TreeNode.of("[4,2,null,3,1]"),
                        1,
                        3,
                        TreeNode.of("[4,2,null,1,1,3,null,null,1]")),
                Arguments.of(TreeNode.of("[2,3,4]"),
                        1,
                        1,
                        TreeNode.of("[1,2,null,3,4]"))
        );
    }

}