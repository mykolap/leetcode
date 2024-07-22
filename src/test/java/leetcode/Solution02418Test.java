package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02418Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sortPeople(String namesStr, String heightsStr, String expectedStr) {
        String[] names = ArrayUtils.stringToStringArray(namesStr);
        int[] heights = ArrayUtils.stringToIntArray(heightsStr);

        String[] actual = new Solution02418().sortPeople(names, heights);

        String actualStr = ArrayUtils.stringArrayToString(actual);
        assertThat(actualStr).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"Mary\",\"John\",\"Emma\"]", "[180,165,170]", "[\"Mary\",\"Emma\",\"John\"]"),
                Arguments.of("[\"Alice\",\"Bob\",\"Bob\"]", "[155,185,150]", "[\"Bob\",\"Alice\",\"Bob\"]")
        );
    }

}