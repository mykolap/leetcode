package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00726Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countOfAtoms(String formula, String expected) {
        String result = new Solution00726().countOfAtoms(formula);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("H2O", "H2O"),
                Arguments.of("Mg(OH)2", "H2MgO2"),
                Arguments.of("K4(ON(SO3)2)2", "K4N2O14S4")
        );
    }

}