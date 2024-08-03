package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01460Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canBeEqual(String targetStr, String arrStr, boolean expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        int[] target = ArrayUtils.stringToIntArray(targetStr);
        assertEquals(expected, new Solution01460().canBeEqual(target, arr));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,4]", "[2,4,1,3]", true),
                Arguments.of("[7]", "[7]", true),
                Arguments.of("[1,12]", "[12,1]", true),
                Arguments.of("[3,7,9]", "[3,7,11]", false),
                Arguments.of("[1,1,1,1,1]", "[1,1,1,1,1]", true)
        );
    }

}