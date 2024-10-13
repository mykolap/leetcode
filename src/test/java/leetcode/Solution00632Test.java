package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00632Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void smallestRange(String numsStr, String expectedStr) {
        List<List<Integer>> nums = ArrayUtils.stringToListOfLists(numsStr);
        int[] actual = new Solution00632().smallestRange(nums);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]", "[20,24]"),
                Arguments.of("[[1,2,3],[1,2,3],[1,2,3]]", "[1,1]")
        );
    }

}