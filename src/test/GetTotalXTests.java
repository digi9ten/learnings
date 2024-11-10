package test;

import main.GetTotalX;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTotalXTests {

    @Test
    void generalTests() {
        assertEquals(3, GetTotalX.getTotalX(List.of(2, 4), List.of(16, 32, 96)));

        assertEquals(2, GetTotalX.getTotalX(List.of(3, 4), List.of(24, 48)));

        assertEquals(2, GetTotalX.getTotalX(List.of(2, 3, 6), List.of(42, 84)));

        assertEquals(1, GetTotalX.getTotalX(List.of(2), List.of(20, 30, 12)));
    }
}
