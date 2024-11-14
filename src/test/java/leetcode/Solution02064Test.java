package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02064Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimizedMaximum(int n, String quantitiesStr, int expected) {
        int[] quantities = ArrayUtils.stringToIntArray(quantitiesStr);
        assertEquals(expected, new Solution02064().minimizedMaximum(n, quantities));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(6, "[11,6]", 3),
                Arguments.of(7, "[15,10,10]", 5),
                Arguments.of(1, "[100000]", 100000)
        );
    }

}