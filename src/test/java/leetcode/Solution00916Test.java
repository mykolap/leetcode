package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00916Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void wordSubsets(String words1Str, String words2Str, String expectedStr) {
        String[] words1 = ArrayUtils.stringToStringArray(words1Str);
        String[] words2 = ArrayUtils.stringToStringArray(words2Str);
        List<String> result = new Solution00916().wordSubsets(words1, words2);
        assertThat(ArrayUtils.stringCollectionToString(result))
                .isEqualTo(expectedStr);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void wordSubsetsTle(String words1Str, String words2Str, String expectedStr) {
        String[] words1 = ArrayUtils.stringToStringArray(words1Str);
        String[] words2 = ArrayUtils.stringToStringArray(words2Str);
        List<String> result = new Solution00916().wordSubsetsTle(words1, words2);
        assertThat(ArrayUtils.stringCollectionToString(result))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"amazon\",\"apple\",\"facebook\",\"google\",\"leetcode\"]",
                        "[\"e\",\"o\"]",
                        "[\"facebook\",\"google\",\"leetcode\"]"),
                Arguments.of("[\"amazon\",\"apple\",\"facebook\",\"google\",\"leetcode\"]",
                        "[\"l\",\"e\"]",
                        "[\"apple\",\"google\",\"leetcode\"]")
        );
    }

}