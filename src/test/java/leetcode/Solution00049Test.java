package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00049Test {

    static Stream<Arguments> getGroupAnagramsArgs() {
        return Stream.of(
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(
                                List.of("bat"),
                                List.of("tan", "nat"),
                                List.of("eat", "tea", "ate")
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("getGroupAnagramsArgs")
    void groupAnagrams(String[] strs, List<List<String>> expected) {
        assertThat(new Solution00049().groupAnagrams(strs))
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("getGroupAnagramsArgs")
    void groupAnagramsCounting(String[] strs, List<List<String>> expected) {
        assertThat(new Solution00049().groupAnagramsCounting(strs))
                .containsExactlyInAnyOrderElementsOf(expected);
    }

}