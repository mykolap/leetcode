package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02385Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of("[1,5,3,null,4,10,6,9,2]"), 3, 4),
                Arguments.of(TreeNode.of("[1]"), 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void amountOfTimeBfs(TreeNode root, int start, int expected) {
        int actual = new Solution02385().amountOfTimeBfs(root, start);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void amountOfTimeDfs(TreeNode root, int start, int expected) {
        int actual = new Solution02385().amountOfTimeDfs(root, start);
        assertEquals(expected, actual);
    }

}