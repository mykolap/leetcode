package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00979Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void distributeCoins(String treeNodeStr, int expected) {
        int result = new Solution00979().distributeCoins(TreeNode.of(treeNodeStr));
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,0,0]", 2),
                Arguments.of("[0,3,0]", 3),
                Arguments.of("[1,0,0,null,3]", 4)
        );
    }

}