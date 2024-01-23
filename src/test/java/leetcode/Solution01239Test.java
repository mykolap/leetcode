package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01239Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(List.of("un", "iq", "ue"), 4),
                Arguments.of(List.of("cha", "r", "act", "ers"), 6),
                Arguments.of(List.of("abcdefghijklmnopqrstuvwxyz"), 26),
                Arguments.of(List.of("aa", "bb"), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxLength(List<String> arr, int expected) {
        Solution01239 solution = new Solution01239();
        int actual = solution.maxLength(arr);
        assertEquals(expected, actual);
    }

}