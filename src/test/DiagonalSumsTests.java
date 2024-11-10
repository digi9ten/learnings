package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static main.DiagonalSums.buildMatrix;
import static main.DiagonalSums.findDiagonalInOrder;

/**
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
 *
 * @see main.DiagonalSums
 */
public class DiagonalSumsTests {

    @Test
    void generalTests() {
        int[][] matrix = buildMatrix();

        int[] expectedOrder = new int[]{4, 7, 9, 3, 6, 3, 8, 8, 4, 7, 7, 6, 2, 7, 2, 1};

        int[] result = findDiagonalInOrder(matrix);

        Assertions.assertEquals(Arrays.toString(result), Arrays.toString(expectedOrder),
                "The function is broken. It was supposed to return " + Arrays.toString(expectedOrder) +
                        " but instead returned " + Arrays.toString(result));
    }
}
