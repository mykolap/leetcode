package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02601Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void primeSubtraction(String numsStr, boolean expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        boolean result = new Solution02601().primeSubOperation(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[4,9,6,10]", true),
                Arguments.of("[6,8,11,12]", true),
                Arguments.of("[5,8,3]", false)
        );
    }

}