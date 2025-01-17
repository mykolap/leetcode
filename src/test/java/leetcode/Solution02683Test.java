package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02683Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minFlips(String derivedStr, boolean expected) {
        int[] derived = ArrayUtils.stringToIntArray(derivedStr);
        assertEquals(expected, new Solution02683().doesValidArrayExist(derived));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,1,0]", true),
                Arguments.of("[1,1]", true),
                Arguments.of("[1,0]", false)
        );
    }

}