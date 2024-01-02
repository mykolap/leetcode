package leetcode.convertAnArrayIntoA2dArrayWithConditions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2610Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 1, 2, 3, 1},
                        List.of(
                                List.of(1, 3, 4, 2),
                                List.of(1, 3),
                                List.of(1)
                        )),
                Arguments.of(new int[]{1, 2, 3, 4},
                        List.of(
                                List.of(1, 2, 3, 4)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMatrix(int[] nums, List<List<Integer>> expected) {
        var actual = new Solution2610().findMatrix(nums);
        assertThat(actual)
                .containsExactlyElementsOf(expected);
    }
}