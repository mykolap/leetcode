package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01331Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void arrayRankTransform(String arrStr, String expected) {
        Solution01331 solution01331 = new Solution01331();
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        var result = solution01331.arrayRankTransform(arr);
        assertThat(Arrays.toString(result).replace(" ", ""))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[40,10,20,30]", "[4,1,2,3]"),
                Arguments.of("[100,100,100]", "[1,1,1]"),
                Arguments.of("[37,12,28,9,100,56,80,5,12]", "[5,3,4,2,8,6,7,1,3]")
        );
    }

}