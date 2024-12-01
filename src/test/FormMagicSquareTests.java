package test;

import main.Util;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static main.FormMagicSquare.formingMagicSquare;

public class FormMagicSquareTests {

    @Test
    public void generalTests() {
        List<List<Integer>> testMatrix = new ArrayList<>();
        testMatrix.add(Arrays.asList(5, 3, 4));
        testMatrix.add(Arrays.asList(1, 5, 8));
        testMatrix.add(Arrays.asList(6, 4, 2));
        assertEquals(7, formingMagicSquare(testMatrix));

        testMatrix = new ArrayList<>();
        testMatrix.add(Arrays.asList(4, 9, 2));
        testMatrix.add(Arrays.asList(3, 5, 7));
        testMatrix.add(Arrays.asList(8, 1, 5));
        assertEquals(1, formingMagicSquare(testMatrix));

        testMatrix = new ArrayList<>();
        testMatrix.add(Arrays.asList(4, 8, 2));
        testMatrix.add(Arrays.asList(4, 5, 7));
        testMatrix.add(Arrays.asList(6, 1, 6));
        assertEquals(4, formingMagicSquare(testMatrix));
    }
}
