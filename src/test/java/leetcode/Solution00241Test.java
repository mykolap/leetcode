package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00241Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void diffWaysToCompute(String expression, String expectedStr) {
        final List<Integer> actual = new Solution00241().diffWaysToCompute(expression);
        assertThat(actual.stream().sorted().toList().toString().replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("2-1-1", "[0,2]"),
                Arguments.of("2*3-4*5", "[-34,-14,-10,-10,10]")
        );
    }

}