package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume you have an MxN matrix, find all the diagonals, from top-right to bottom-right.
 * Once you find the diagonals, provide the sum of each.
 * <p>
 * Below is an example matrix to test with:
 * <p>
 * ==============
 * 4  7  3  8
 * 9  6  8  2
 * 3  4  6  7
 * 7  7  2  1
 * ==============
 * <p>
 * Starting from the left, the diagonal order should be:
 * [4, 7, 9, 3, 6, 3, 8, 8, 4, 7, 7, 6, 2, 7, 2, 1]
 * <p>
 */
public class DiagonalSums {

    /**
     * Start from the top left, ends at the bottom right
     *
     * @param matrix 2D array of integers
     * @return the found integers following the described order
     */
    public static int[] findDiagonalInOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] matrixAsArray = new int[rows * cols];
        int currentRow = 0, currentCol = 0;

        int index = 0;
        while (index < matrixAsArray.length) {
            matrixAsArray[index++] = matrix[currentRow][currentCol];

            if ((currentRow + currentCol) % 2 == 0) {
                if (currentCol < cols - 1 && currentRow > 0) {
                    currentCol++;
                    currentRow--;

                } else if (currentCol < cols - 1) {
                    currentCol++;

                } else {
                    currentRow++;
                }
            } else {
                if (currentRow < rows - 1 && currentCol > 0) {
                    currentCol--;
                    currentRow++;

                } else if (currentRow < rows - 1) {
                    currentRow++;

                } else {
                    currentCol++;
                }
            }
        }

        return matrixAsArray;
    }

    public static List<int[]> findAllDiagonalLeftToRight(int[][] matrix) {
        int rows = matrix.length;
        List<int[]> resultingDiagonals = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            resultingDiagonals.add(findDiagonalLeftToRightStartingFromGivenRow(matrix, row));
        }

        return resultingDiagonals;
    }

    private static int[] findDiagonalLeftToRightStartingFromGivenRow(int[][] matrix, int startingRow) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> resultingDiagonal = new ArrayList<>();
        int currentRow = startingRow, currentCol = 0;

        if (startingRow < rows) {
            for (int matrixCol = 0; matrixCol < cols; matrixCol++) {
                resultingDiagonal.add(matrix[currentRow][currentCol]);

                if ((currentRow + currentCol) % 2 == 0) {
                    if (currentCol < cols - 1 && currentRow > 0) {
                        currentCol++;
                        currentRow--;

                    } else if (currentCol < cols - 1) {
                        currentCol++;

                    } else {
                        currentRow++;
                    }
                }
            }
        }

        return resultingDiagonal.stream().mapToInt(i -> i).toArray();
    }

    public static int[][] buildMatrix() {
        return new int[][]{
                {4, 7, 3, 8},
                {9, 6, 8, 2},
                {3, 4, 6, 7},
                {7, 7, 2, 1}
        };
    }
}
