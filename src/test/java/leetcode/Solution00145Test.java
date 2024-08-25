package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00145Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void postorderTraversal(String input, String expected) {
        TreeNode root = TreeNode.of(input);
        assertEquals(expected, new Solution00145().postorderTraversal(root).toString().replace(" ", ""));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("1,null,2,3", "[3,2,1]"),
                Arguments.of("", "[]"),
                Arguments.of("1", "[1]"),
                Arguments.of("1,2", "[2,1]"),
                Arguments.of("1,null,2", "[2,1]"),
                Arguments.of("1,2,3,4,5,6,7", "[4,5,2,6,7,3,1]")
        );
    }

}