package test;

import org.junit.jupiter.api.Test;

import static main.ClockByAngles.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockByAnglesTests {

    @Test
    void generalTests() {
        int angle = calculate(9, 60);
        assertEquals(90, angle, "For 9:00 it should be 90: " + angle);

        angle = calculate(3, 30);
        assertEquals(75, angle, "For 3:30 it should be 75: " + angle);

        angle = calculate(2, 15);
        assertEquals(23, angle, "For 2:15 it should be 23: " + angle);

        angle = calculate(12, 45);
        assertEquals(112, angle, "For 12:45 it should be 112: " + angle);

        angle = calculate(11, 45);
        assertEquals(82, angle, "For 11:45 it should be 82: " + angle);
    }
}
