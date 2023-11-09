package leetcode.validAnagram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getIsAnagramArgs() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArgs")
    void isAnagramSorting(String s, String t, boolean expected) {
        assertEquals(expected, new Solution().isAnagramSorting(s, t));
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArgs")
    void isAnagramMap(String s, String t, boolean expected) {
        assertEquals(expected, new Solution().isAnagramMap(s, t));
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArgs")
    void isAnagram(String s, String t, boolean expected) {
        assertEquals(expected, new Solution().isAnagram(s, t));
    }

}