package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00036Test {

    static Stream<Arguments> getIsValidSudokuArgs() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '8', '.', '.', '.', '.', '.', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '.', '.', '.', '.', '.', '1'},
                        {'7', '.', '.', '.', '.', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '1', '.', '.', '.', '5'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                }, true),
                Arguments.of(new char[][]{
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '.', '.', '.', '.', '.', '1'},
                        {'7', '.', '.', '.', '.', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '1', '.', '.', '.', '5'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                }, false)
        );
    }

    @ParameterizedTest
    @MethodSource("getIsValidSudokuArgs")
    void isValidSudoku(char[][] board, boolean expected) {
        assertEquals(expected, new Solution00036().isValidSudoku(board));
    }

    @ParameterizedTest
    @MethodSource("getIsValidSudokuArgs")
    void isValidSudokuSimplified(char[][] board, boolean expected) {
        assertEquals(expected, new Solution00036().isValidSudokuSimplified(board));
    }

}