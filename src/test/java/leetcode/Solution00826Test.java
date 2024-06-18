package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00826Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxProfitAssignment(String difficultyStr, String profitStr, String workerStr, int expected) {
        int[] difficulty = ArrayUtils.stringToIntArray(difficultyStr);
        int[] profit = ArrayUtils.stringToIntArray(profitStr);
        int[] worker = ArrayUtils.stringToIntArray(workerStr);
        int result = new Solution00826().maxProfitAssignment(difficulty, profit, worker);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,4,6,8,10]", "[10,20,30,40,50]", "[4,5,6,7]", 100),
                Arguments.of("[85,47,57]", "[24,66,99]", "[40,25,25]", 0),
                Arguments.of("[68,35,52,47,86]", "[67,17,1,81,3]", "[92,10,85,84,82]", 324),
                Arguments.of("[68,35,52,47,86]", "[67,17,1,81,3]", "[92,10,85,84,82,88]", 405)
        );
    }

}