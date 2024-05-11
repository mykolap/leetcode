package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00857Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mincostToHireWorkers(String qualityStr, String wageStr, int k, double expected) {
        int[] quality = ArrayUtils.stringToIntArray(qualityStr);
        int[] wage = ArrayUtils.stringToIntArray(wageStr);
        double result = new Solution00857().mincostToHireWorkers(quality, wage, k);
        assertEquals(expected, result, 1e-5);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[10,20,5]", "[70,50,30]", 2, 105.0),
                Arguments.of("[3,1,10,10,1]", "[4,8,2,2,7]", 3, 30.66667)
        );
    }
}