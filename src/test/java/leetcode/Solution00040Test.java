package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00040Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void combinationSum2(String candidatesStr, int target, String expectedStr) {
        int[] candidates = ArrayUtils.stringToIntArray(candidatesStr);
        final List<List<Integer>> result = new Solution00040().combinationSum2(candidates, target);
        assertThat(result.toString().replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[10,1,2,7,6,1,5]", 8, "[[1,1,6],[1,2,5],[1,7],[2,6]]"),
                Arguments.of("[2,5,2,1,2]", 5, "[[1,2,2],[5]]")
        );
    }

}