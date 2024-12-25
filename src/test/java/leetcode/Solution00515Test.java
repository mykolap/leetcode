package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00515Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void largestValues(String rootStr, String expectedStr) {
        TreeNode root = TreeNode.of(rootStr);
        List<Integer> actual = new Solution00515().largestValues(root);
        assertThat(actual.toString().replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    /*
    Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
     */
    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3,2,5,3,null,9]", "[1,3,9]"),
                Arguments.of("[1,2,3]", "[1,3]")
        );
    }

}