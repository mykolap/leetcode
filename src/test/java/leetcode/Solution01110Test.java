package leetcode;

import leetcode.common.ArrayUtils;
import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01110Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void delNodes(String rootStr, String toDeleteStr, String expected) {
        TreeNode root = TreeNode.of(rootStr);
        Solution01110 solution = new Solution01110();
        int[] toDelete = ArrayUtils.stringToIntArray(toDeleteStr);
        List<TreeNode> result = solution.delNodes(root, toDelete);
        assertThat(result.toString().replace(" ", ""))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,4,null,3]", "[3]", "[[1,2,4]]")
        );
    }

}