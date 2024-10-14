package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02530Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxKelements(String numsStr, int k, long expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        long result = new Solution02530().maxKelements(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[10,10,10,10,10]", 5, 50),
                Arguments.of("[1,10,3,3,3]", 3, 17)
        );
    }

}