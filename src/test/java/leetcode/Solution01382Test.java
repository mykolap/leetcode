package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01382Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void balanceBST(String treeStr, String expectedTreeStr) {
        TreeNode root = TreeNode.of(treeStr);
        TreeNode actual = new Solution01382().balanceBST(root);
        assertThat(actual).hasToString(expectedTreeStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,null,2,null,3,null,4,null,null]", "[2,1,3,null,null,null,4]"),
                Arguments.of("[2,1,3]", "[2,1,3]"),
                Arguments.of("[1,null,15,14,17,7]", "[14,1,15,null,7,null,17]")
        );
    }

}