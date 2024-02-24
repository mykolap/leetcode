package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02092Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findAllPeople(int n, int[][] meetings, int firstPerson, List<Integer> expected) {
        assertThat(new Solution02092().findAllPeople(n, meetings, firstPerson))
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(6,
                        new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}},
                        1,
                        List.of(0, 1, 2, 3, 5)),
                Arguments.of(4,
                        new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}},
                        3,
                        List.of(0, 1, 3)),
                Arguments.of(5,
                        new int[][]{{3, 4, 2}, {1, 2, 1}, {2, 3, 1}},
                        1,
                        List.of(0, 1, 2, 3, 4)),
                Arguments.of(6,
                        new int[][]{{0, 2, 1}, {1, 3, 1}, {4, 5, 1}},
                        1,
                        List.of(0, 1, 2, 3))
        );
    }

}