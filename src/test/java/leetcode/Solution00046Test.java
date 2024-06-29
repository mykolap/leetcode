package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00046Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void permute(String numsStr, String expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        List<List<Integer>> actual = new Solution00046().permute(nums);
        assertThat(ArrayUtils.listOfListsToString(actual))
                .isEqualTo(expected);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3]", "[[1,2,3],[2,1,3],[2,3,1],[1,3,2],[3,1,2],[3,2,1]]"),
                Arguments.of("[0,1]", "[[0,1],[1,0]]"),
                Arguments.of("[1]", "[[1]]")
        );
    }

}