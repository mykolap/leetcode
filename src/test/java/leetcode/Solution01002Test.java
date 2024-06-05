package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution01002Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void commonChars(String[] words, String[] expected) {
        var solution = new Solution01002();
        var result = solution.commonChars(words);
        assertArrayEquals(expected, result.toArray());
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new String[]{"bella", "label", "roller"}, new String[]{"e", "l", "l"}),
                Arguments.of(new String[]{"cool", "lock", "cook"}, new String[]{"c", "o"})
        );
    }

}