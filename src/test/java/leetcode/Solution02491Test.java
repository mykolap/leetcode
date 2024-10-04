package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02491Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void dividePlayers(String skillStr, long expected) {
        int[] skill = ArrayUtils.stringToIntArray(skillStr);
        long result = new Solution02491().dividePlayers(skill);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,2,5,1,3,4]", 22),
                Arguments.of("[3,4]", 12),
                Arguments.of("[1,1,2,3]", -1)
        );
    }

}