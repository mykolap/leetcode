package leetcode.common;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static int[] stringToIntArray(String str) {
        // Remove the brackets and split the string by comma
        String[] strArray = str.replace("[", "").replace("]", "").split(",");

        // Convert each element to an integer
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i].trim());
        }

        return intArray;
    }

    public static String stringArrayToString(String[] strArray) {
        return Arrays.stream(strArray).collect(Collectors.joining("\",\"", "[\"", "\"]"));
    }

    public static String intArrayToString(int[] intArray) {
        return Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    public static int[][] stringTo2DIntArray(String str) {
        // Remove the outer brackets and split the string by "],["
        String[] strRows = str.substring(1, str.length() - 1).split("\\],\\[");

        // Convert each row string to an integer array
        int[][] matrix = new int[strRows.length][];
        for (int i = 0; i < strRows.length; i++) {
            matrix[i] = ArrayUtils.stringToIntArray("[" + strRows[i] + "]");
        }

        return matrix;
    }

    public static String int2DArrayToString(int[][] matrix) {
        return Arrays.stream(matrix)
                .map(ArrayUtils::intArrayToString)
                .collect(Collectors.joining(",", "[", "]"));
    }

}
