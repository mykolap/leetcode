package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00039Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 3, 6, 7},
                        7,
                        List.of(
                                List.of(2, 2, 3),
                                List.of(7)

                        ),
                        Arguments.of(
                                new int[]{2, 3, 5},
                                8,
                                List.of(
                                        List.of(2, 2, 2, 2),
                                        List.of(2, 3, 3),
                                        List.of(3, 5)
                                )
                        ),
                        Arguments.of(
                                new int[]{2},
                                1,
                                List.of()
                        ),
                        Arguments.of(
                                new int[]{1},
                                1,
                                List.of(
                                        List.of(1)
                                )
                        ),
                        Arguments.of(
                                new int[]{1},
                                2,
                                List.of(
                                        List.of(1, 1)
                                )
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void combinationSum(int[] candidates, int target, List<List<Integer>> expected) {
        var solution = new Solution00039();
        var actual = solution.combinationSum(candidates, target);
        assertThat(actual)
                .containsExactlyElementsOf(expected);
    }
}