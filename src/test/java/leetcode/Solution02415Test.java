package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02415Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseOddLevels(String treeStr, String expectedStr) {
        TreeNode root = TreeNode.of(treeStr);
        TreeNode actual = new Solution02415().reverseOddLevels(root);
        assertThat(actual)
                .hasToString(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,3,5,8,13,21,34]", "[2,5,3,8,13,21,34]"),
                Arguments.of("[7,13,11]", "[7,11,13]"),
                Arguments.of("[0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]", "[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]")
        );
    }

}