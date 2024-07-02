package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01550Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void threeConsecutiveOdds(String arrStr, boolean expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        assertEquals(expected, new Solution01550().threeConsecutiveOdds(arr));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,6,4,1]", false),
                Arguments.of("[1,2,34,3,4,5,7,23,12]", true)
        );
    }

}