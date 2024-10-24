package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02641Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void replaceValueInTree(String rootStr, String expectedStr) {
        Solution02641 solution02641 = new Solution02641();
        TreeNode root = TreeNode.of(rootStr);
        var actual = solution02641.replaceValueInTree(root);
        assertThat(actual).hasToString(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,4,9,1,10,null,7]", "[0,0,0,7,7,null,11]"),
                Arguments.of("[3,1,2]", "[0,0,0]")
        );
    }

}