package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00538Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void convertBST(String treeStr, String expectedTreeStr) {
        TreeNode root = TreeNode.of(treeStr);
        TreeNode actual = new Solution00538().convertBST(root);
        assertThat(actual).hasToString(expectedTreeStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]", "[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]"),
                Arguments.of("[0,null,1]", "[1,null,1]")
        );
    }

}