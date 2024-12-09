package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution03152Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isArraySpecial(String numsStr, String queriesStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int[][] queries = ArrayUtils.stringToInt2DArray(queriesStr);
        boolean[] actual = new Solution03152().isArraySpecial(nums, queries);
        assertThat(Arrays.toString(actual).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,4,1,2,6]", "[[0,4]]", "[false]"),
                Arguments.of("[4,3,1,6]", "[[0,2],[2,3]]", "[false,true]")
        );
    }

}