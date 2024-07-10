package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01701Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void averageWaitingTime(String customersStr, double expected) {
        int[][] customers = ArrayUtils.stringTo2DIntArray(customersStr);
        double result = new Solution01701().averageWaitingTime(customers);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,2],[2,5],[4,3]]", 5.0),
                Arguments.of("[[5,2],[5,4],[10,3],[20,1]]", 3.25)
        );
    }

}