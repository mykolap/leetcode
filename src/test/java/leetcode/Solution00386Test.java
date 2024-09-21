package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00386Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lexicalOrder(int n, String expectedStr) {
        List<Integer> actual = new Solution00386().lexicalOrder(n);
        assertThat(actual.toString().replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(13, "[1,10,11,12,13,2,3,4,5,6,7,8,9]"),
                Arguments.of(1, "[1]"),
                Arguments.of(2, "[1,2]")
        );
    }

}