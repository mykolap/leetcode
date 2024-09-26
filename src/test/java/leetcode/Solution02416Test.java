package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02416Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumPrefixScores(String[] words, String expectedStr) {
        var actual = new Solution02416().sumPrefixScores(words);
        assertThat(Arrays.toString(actual).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new String[]{"abc", "ab", "bc", "b"}, "[5,4,3,2]"),
                Arguments.of(new String[]{"abcd"}, "[4]")
        );
    }

}