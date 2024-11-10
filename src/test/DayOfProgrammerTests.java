package test;

import main.DayOfProgrammer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DayOfProgrammerTests {

    @Test
    void generalTexts(){
        assertEquals("11.09.0001", DayOfProgrammer.findDOPForYear(0));

        assertEquals("12.09.0356", DayOfProgrammer.findDOPForYear(356));

        assertEquals("13.09.2017", DayOfProgrammer.findDOPForYear(2017));

        assertEquals("12.09.2016", DayOfProgrammer.findDOPForYear(2016));

        assertEquals("12.09.1800", DayOfProgrammer.findDOPForYear(1800));

        assertEquals("12.09.1908", DayOfProgrammer.findDOPForYear(1908));

        assertEquals("13.09.1917", DayOfProgrammer.findDOPForYear(1917));

        assertEquals("13.09.3059", DayOfProgrammer.findDOPForYear(3059));
    }

    @Test
    void testBadParameter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DayOfProgrammer.findDOPForYear(-5));

    }
}
