package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02558Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void pickGifts(String giftsStr, int k, long expected) {
        int[] gifts = ArrayUtils.stringToIntArray(giftsStr);
        long actual = new Solution02558().pickGifts(gifts, k);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[25,64,9,4,100]", 4, 29),
                Arguments.of("[1,1,1,1]", 4, 4)
        );
    }

}