package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00506Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findRelativeRanks(String scoreStr, String expected) {
        Solution00506 solution = new Solution00506();
        String[] actual = solution.findRelativeRanks(ArrayUtils.stringToIntArray(scoreStr));
        assertThat(ArrayUtils.stringArrayToString(actual)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findRelativeRanksPriorityQueue(String scoreStr, String expected) {
        Solution00506 solution = new Solution00506();
        String[] actual = solution.findRelativeRanksPriorityQueue(ArrayUtils.stringToIntArray(scoreStr));
        assertThat(ArrayUtils.stringArrayToString(actual)).isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,4,3,2,1]", "[\"Gold Medal\",\"Silver Medal\",\"Bronze Medal\",\"4\",\"5\"]"),
                Arguments.of("[10,3,8,9,4]", "[\"Gold Medal\",\"5\",\"Bronze Medal\",\"Silver Medal\",\"4\"]")
        );
    }
}