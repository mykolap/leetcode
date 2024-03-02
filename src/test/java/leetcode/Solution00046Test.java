package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00046Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        List.of(
                                List.of(3, 2, 1),
                                List.of(2, 3, 1),
                                List.of(2, 1, 3),
                                List.of(3, 1, 2),
                                List.of(1, 3, 2),
                                List.of(1, 2, 3)
                        )
                ),
                Arguments.of(
                        new int[]{0, 1},
                        List.of(
                                List.of(1, 0),
                                List.of(0, 1)
                        )
                ),
                Arguments.of(
                        new int[]{1},
                        List.of(
                                List.of(1)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void permute(int[] nums, List<List<Integer>> expected) {
        var solution = new Solution00046();
        var actual = solution.permute(nums);
        assertThat(actual)
                .containsExactlyElementsOf(expected);
    }

}