package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02751Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void survivedRobotsHealths(String positionsStr, String healthsStr, String directions, String expectedStr) {
        int[] positions = ArrayUtils.stringToIntArray(positionsStr);
        int[] healths = ArrayUtils.stringToIntArray(healthsStr);
        var result = new Solution02751().survivedRobotsHealths(positions, healths, directions)
                .toString().replace(" ", "");
        assertThat(result).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,4,3,2,1]", "[2,17,9,15,10]", "RRRRR", "[2,17,9,15,10]"),
                Arguments.of("[3,5,2,6]", "[10,10,15,12]", "RLRL", "[14]"),
                Arguments.of("[1,2,5,6]", "[10,10,11,11]", "RLRL", "[]")
        );
    }

}