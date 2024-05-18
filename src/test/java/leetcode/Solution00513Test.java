package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00513Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findBottomLeftValue(TreeNode root, int expected) {
        assertEquals(expected, new Solution00513().findBottomLeftValue(root));
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of("[2,1,3]"), 1),
                Arguments.of(TreeNode.of("[1,2,3,4,null,5,6,null,null,7]"), 7)
        );
    }

}