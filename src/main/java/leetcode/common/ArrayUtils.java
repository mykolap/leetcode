package leetcode.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static int[] stringToIntArray(String str) {
        if (str == null || str.isEmpty()) {
            return new int[0];
        }

        // Remove the brackets and split the string by comma
        String[] strArray = str.replace("[", "").replace("]", "").split(",");

        // Convert each element to an integer
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i].trim());
        }

        return intArray;
    }

    public static List<Integer> stringToIntList(String str) {
        final int[] ints = stringToIntArray(str);
        if (ints.length == 0) {
            return List.of();
        }
        List<Integer> list = new ArrayList<>(ints.length);
        for (int anInt : ints) {
            list.add(anInt);
        }
        return list;
    }

    public static List<String> stringToStringList(String str) {
        String[] strArray = stringToStringArray(str);

        return Arrays.asList(strArray);
    }

    public static String[] stringToStringArray(String str) {
        if (str == null || str.isEmpty() || str.equals("[]")) {
            return new String[0];
        }

        return str.replaceAll("[\\[\\]\"]", "").split(",");
    }

    public static String stringArrayToString(String[] strArray) {
        return Arrays.stream(strArray).collect(Collectors.joining("\",\"", "[\"", "\"]"));
    }

    public static String stringCollectionToString(Collection<String> stringCollection) {
        return stringCollection.stream().collect(Collectors.joining("\",\"", "[\"", "\"]"));
    }

    public static String intArrayToString(int[] intArray) {
        return Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    public static int[][] stringToInt2DArray(String str) {
        // Remove the outer brackets and split the string by "],["
        String strippedOuter = str.substring(1, str.length() - 1);
        if (strippedOuter.isEmpty()) {
            return new int[0][0];
        }
        strippedOuter = strippedOuter.replaceAll("\\s", "");
        String[] strRows = strippedOuter.split("\\],\\[");

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

    public static List<List<Integer>> stringToListOfLists(String str) {
        int[][] matrix = stringToInt2DArray(str);
        List<List<Integer>> matrixList = new ArrayList<>(matrix.length);
        for (int[] arr : matrix) {
            matrixList.add(Arrays.stream(arr).boxed().toList());
        }
        return matrixList;
    }

    public static String listOfListsToString(List<List<Integer>> matrixList) {
        String standardToString = matrixList.toString();
        return standardToString.replace(" ", "");
    }


    public static char[] stringToCharArray(String lettersStr) {
        return lettersStr.replaceAll("[\\[\\]\",]", "").toCharArray();
    }

    public static String charArrayToString(char[] charArray) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < charArray.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            char c = charArray[i];
            sb.append('"')
                    .append(c)
                    .append('"');
        }
        sb.append(']');
        return sb.toString();
    }

    public static char[][] stringToChar2DArray(String str) {
        // Remove the outer brackets and split the string by "],["
        String strippedOuter = str.substring(1, str.length() - 1);
        if (strippedOuter.isEmpty()) {
            return new char[0][0];
        }
        strippedOuter = strippedOuter.replaceAll("\\s", "");
        String[] strRows = strippedOuter.split("\\],\\[");

        // Convert each row string to a char array
        char[][] matrix = new char[strRows.length][];
        for (int i = 0; i < strRows.length; i++) {
            matrix[i] = ArrayUtils.stringToCharArray("[" + strRows[i] + "]");
        }

        return matrix;
    }

    public static String char2DArrayToString(char[][] matrix) {
        return Arrays.stream(matrix)
                .map(ArrayUtils::charArrayToString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public static double[] stringToDoubleArray(String str) {
        if (str == null || str.isEmpty()) {
            return new double[0];
        }

        // Remove the brackets and split the string by comma
        String[] strArray = str.replace("[", "").replace("]", "").split(",");

        // Convert each element to a double
        double[] doubleArray = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i].trim());
        }

        return doubleArray;
    }

}
