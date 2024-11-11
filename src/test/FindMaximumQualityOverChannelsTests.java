package test;

import org.junit.jupiter.api.Test;

import static main.FindMaximumQualityOverChannels.highestQuality;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaximumQualityOverChannelsTests {

    @Test
    void generalTests() {
        int[] list = new int[]{1, 2, 3, 4, 5};
        assertEquals(8, Math.round(highestQuality(list, 2)));

        list = new int[]{14, 7};
        assertEquals(14, Math.round(highestQuality(list, 2)));

        list = new int[]{1, 2, 3, 4, 5, 7, 14};
        assertEquals(25, Math.round(highestQuality(list, 3)));

        list = new int[]{21, 33, 67, 8, 333, 93, 4, 5};
        assertEquals(508, Math.round(highestQuality(list, 4)));
    }
}
