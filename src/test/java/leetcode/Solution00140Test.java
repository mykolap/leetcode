package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00140Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void wordBreak(String s, String wordDict, String expected) {
        final List<String> strings = new Solution00140().wordBreak(s, ArrayUtils.stringToStringList(wordDict));
        List<String> expectedList = ArrayUtils.stringToStringList(expected);
        assertThat(strings)
                .containsExactlyInAnyOrderElementsOf(expectedList);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("catsanddog",
                        "[\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]",
                        "[\"cats and dog\",\"cat sand dog\"]"),
                Arguments.of("pineapplepenapple",
                        "[\"apple\",\"pen\",\"applepen\",\"pine\",\"pineapple\"]",
                        "[\"pine apple pen apple\",\"pine applepen apple\",\"pineapple pen apple\"]"),
                Arguments.of("catsandog",
                        "[\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]",
                        "[]")
        );
    }
}