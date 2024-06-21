package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01052Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxSatisfied(String customersStr, String grumpyStr, int X, int expected) {
        int[] customers = ArrayUtils.stringToIntArray(customersStr);
        int[] grumpy = ArrayUtils.stringToIntArray(grumpyStr);
        int result = new Solution01052().maxSatisfied(customers, grumpy, X);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,0,1,2,1,1,7,5]", "[0,1,0,1,0,1,0,1]", 3, 16),
                Arguments.of("[4,10,10]", "[1,1,0]", 2, 24),
                Arguments.of("[1]", "[0]", 1, 1),
                Arguments.of("[9,10,4,5]", "[1,0,1,1]", 1, 19),
                Arguments.of("[22,609,498,467,957,156,897,839,136,382,43,395,910,662,496,472,582,573,355,849,174,77,900,751,487,530,566,350,15,351,793,166,698,583,858,895,907,942,2,512,895,30,270,585,838,271,905,476,217,536]",
                        "[1,0,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,1,1,0,1,0,1,0,0,0,0,1,1,0,1,1,1,0,0,0,1,1,1,0,0,1,0,1,1,0,0,0,0,0]", 26, 22176)
        );
    }

}