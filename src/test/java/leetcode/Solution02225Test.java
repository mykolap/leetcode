package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02225Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}},
                        List.of(List.of(1, 2, 10), List.of(4, 5, 7, 8))),
                Arguments.of(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}},
                        List.of(List.of(1, 2, 5, 6), List.of()))
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findWinners(int[][] matches, List<List<Integer>> expected) {
        assertThat(new Solution02225().findWinners(matches))
                .containsExactlyElementsOf(expected);
    }

}