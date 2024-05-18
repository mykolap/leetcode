package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00105Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7},
                        TreeNode.of("[3,9,20,null,null,15,7]")),
                Arguments.of(new int[]{-1}, new int[]{-1},
                        TreeNode.of("[-1]"))
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void buildTree(int[] preorder, int[] inorder, TreeNode expected) {
        assertThat(new Solution00105().buildTree(preorder, inorder))
                .hasToString(expected.toString());
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void buildTreeWithMap(int[] preorder, int[] inorder, TreeNode expected) {
        assertThat(new Solution00105().buildTreeWithMap(preorder, inorder))
                .hasToString(expected.toString());
    }

}