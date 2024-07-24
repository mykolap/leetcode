package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02191Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sortJumbled(String mappingStr, String numsStr, String expectedStr) {
        int[] mapping = ArrayUtils.stringToIntArray(mappingStr);
        int[] nums = ArrayUtils.stringToIntArray(numsStr);

        int[] result = new Solution02191().sortJumbled(mapping, nums);
        assertThat(Arrays.toString(result).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[8,9,4,0,2,1,3,5,7,6]", "[991,338,38]", "[338,38,991]"),
                Arguments.of("[0,1,2,3,4,5,6,7,8,9]", "[789,456,123]", "[123,456,789]"),
                Arguments.of("[9,8,7,6,5,4,3,2,1,0]", "[0,1,2,3,4,5,6,7,8,9]", "[9,8,7,6,5,4,3,2,1,0]")
        );
    }

}