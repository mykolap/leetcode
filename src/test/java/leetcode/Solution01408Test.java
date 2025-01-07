package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01408Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void stringMatching(String wordsStr, String expectedStr) {
        String[] words = ArrayUtils.stringToStringArray(wordsStr);
        final List<String> actual = new Solution01408().stringMatching(words);
        assertThat(ArrayUtils.stringCollectionToString(actual))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"mass\",\"as\",\"hero\",\"superhero\"]", "[\"as\",\"hero\"]"),
                Arguments.of("[\"leetcode\",\"et\",\"code\"]", "[\"et\",\"code\"]"),
                Arguments.of("[\"blue\",\"green\",\"bu\"]", "[]"),
                Arguments.of("[\"leetcoder\",\"leetcode\",\"od\",\"hamlet\",\"am\"]", "[\"leetcode\",\"od\",\"am\"]")
        );
    }

}