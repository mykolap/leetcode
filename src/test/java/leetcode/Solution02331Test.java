package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02331Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void evaluateTree(Integer[] treeArr, boolean expected) {
        final TreeNode root = TreeNode.of(treeArr);
        boolean result = new Solution02331().evaluateTree(root);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new Integer[]{2, 1, 3, null, null, 0, 1}, true),
                Arguments.of(new Integer[]{0}, false)
        );
    }

}