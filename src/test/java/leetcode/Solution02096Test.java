package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02096Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getDirections(String rootStr, int startValue, int destValue, String expected) {
        TreeNode root = TreeNode.of(rootStr);
        Solution02096 solution = new Solution02096();
        String result = solution.getDirections(root, startValue, destValue);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,1,2,3,null,6,4]", 3, 6, "UURL"),
                Arguments.of("[2,1]", 2, 1, "L")
        );
    }

}