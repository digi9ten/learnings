package main;

import java.util.List;

/**
 * Hackerrank question - https://www.hackerrank.com/challenges/magic-square-forming/problem?isFullScreen=true
 * <br/>
 * Permalink to the best java solution I saw - https://www.hackerrank.com/challenges/magic-square-forming/forum/comments/1469035
 */
public class FormMagicSquare {

    /**
     * Complete the 'formingMagicSquare' function below.
     * <p>
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    public static int formingMagicSquare(List<List<Integer>> s) {
        // define magic square impossible value, is 8 value
        int[][] magicSquare = {
                {8, 1, 6, 3, 5, 7, 4, 9, 2},
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
                {4, 9, 2, 3, 5, 7, 8, 1, 6},
                {2, 9, 4, 7, 5, 3, 6, 1, 8},
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {6, 7, 2, 1, 5, 9, 8, 3, 4},
                {2, 7, 6, 9, 5, 1, 4, 3, 8}
        };

        int index = 0;
        // convert List to array
        int[] matrixArray = new int[9];

        // add list to array
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                int valueMatrix = s.get(i).get(j);
                matrixArray[index] = valueMatrix;
                index++;
            }
        }

        int[] arrayGapMatrix = new int[8];
        int countPossibleCost = 0;

        // compare to matrix square and calculate gap value
        for (int i = 0; i < magicSquare.length; i++) {
            int countPosibleCostOne = 0;
            for (int j = 0; j < magicSquare[i].length; j++) {
                int valueMagicSquare = magicSquare[i][j];
                int valueMatrixArray = matrixArray[j];

                int gapCost = Math.abs(valueMagicSquare - valueMatrixArray);
                countPosibleCostOne = countPosibleCostOne + gapCost;
                arrayGapMatrix[i] = countPosibleCostOne;
            }
        }

        // find min value
        for (int j = 0; j < arrayGapMatrix.length; j++) {
            int valueGap = arrayGapMatrix[j];

            if (valueGap == 0) {
                countPossibleCost = valueGap;
                j = 8;
            } else if (countPossibleCost > valueGap || countPossibleCost == 0)
                countPossibleCost = valueGap;
        }
        return countPossibleCost;
    }
}
