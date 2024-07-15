package leetcode;

import leetcode.common.ArrayUtils;
import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02196Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void createBinaryTree(String descriptionsStr, String expectedStr) {
        int[][] descriptions = ArrayUtils.stringTo2DIntArray(descriptionsStr);
        TreeNode result = new Solution02196().createBinaryTree(descriptions);
        assertThat(result).hasToString(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]", "[50,20,80,15,17,19]"),
                Arguments.of("[[1,2,1],[2,3,0],[3,4,1]]", "[1,2,null,null,3,4]")
        );
    }

}