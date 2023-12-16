package leetcode.subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution0078Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        List.of(
                                List.of(1, 2, 3),
                                List.of(1, 2),
                                List.of(1, 3),
                                List.of(1),
                                List.of(2, 3),
                                List.of(2),
                                List.of(3),
                                List.of()
                        )
                ),
                Arguments.of(
                        new int[]{1, 2},
                        List.of(
                                List.of(1, 2),
                                List.of(1),
                                List.of(2),
                                List.of()
                        )
                ),
                Arguments.of(
                        new int[]{0},
                        List.of(
                                List.of(0),
                                List.of()
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void subsets(final int[] nums, final List<List<Integer>> expected) {
        final List<List<Integer>> subsets = new Solution0078().subsets(nums);
        assertThat(subsets)
                .containsExactlyElementsOf(expected);
    }

}