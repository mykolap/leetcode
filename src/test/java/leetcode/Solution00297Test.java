package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00297Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 2, 3, null, null, 4, 5), """
                               1       \s
                           2       3   \s
                                 4   5 \s
                        """),
                Arguments.of(TreeNode.of(), null),
                Arguments.of(TreeNode.of(1), " 1  \n"),
                Arguments.of(TreeNode.of(1, 2), """
                           1   \s
                         2     \s
                        """),
                Arguments.of(TreeNode.of(1, 2, 3), """
                           1   \s
                         2   3 \s
                        """)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void testCodecSerializeDeserializeBfs(TreeNode root, String expected) {
        Solution00297.Codec codec = new Solution00297.CodecBfs();
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        if (expected == null) {
            assertThat(deserialized).isNull();
        } else {
            assertThat(deserialized)
                    .hasToString(expected);
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void testCodecSerializeDeserializeDfs(TreeNode root, String expected) {
        Solution00297.Codec codec = new Solution00297.CodecDfs();
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        if (expected == null) {
            assertThat(deserialized).isNull();
        } else {
            assertThat(deserialized)
                    .hasToString(expected);
        }
    }

}