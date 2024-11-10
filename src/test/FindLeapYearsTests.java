package test;

import main.FindLeapYears;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindLeapYearsTests {

    @Test
    void generalTests() {
        List<Integer> result = FindLeapYears.findLeapYears(356, 3065);
        assertEquals(658, result.size());

        assertTrue(result.contains(356));
        assertTrue(result.contains(1696));
        assertTrue(result.contains(1704));
        assertTrue(result.contains(2020));

        Assertions.assertFalse(result.contains(1700));
    }
}
