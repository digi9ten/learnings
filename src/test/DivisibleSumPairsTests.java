package test;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static main.DivisibleSumPairs.betterDivisibleSumPairs;
import static main.DivisibleSumPairs.bruteForceDivisibleSumPairs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DivisibleSumPairsTests {

    @Test
    void generalTests() {
        // odd length array
        assertEquals(0, bruteForceDivisibleSumPairs(6, 3, Arrays.asList(3, 2, 6)));

        assertEquals(5, bruteForceDivisibleSumPairs(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2)));
        assertEquals(5, betterDivisibleSumPairs(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2)));
    }

    @Test
    void timeTests() {
        // After 10,000 elements, it takes a bit to run
        List<Integer> largerCollection = produceRandomizedArrayOfIntegers(10000);
        int collectionSize = largerCollection.size();

        Instant instantA = Instant.now();
        bruteForceDivisibleSumPairs(collectionSize, 3, largerCollection);
        Instant instantB = Instant.now();
        Duration bruteRun = Duration.between(instantA, instantB);

        instantA = Instant.now();
        betterDivisibleSumPairs(collectionSize, 3, largerCollection);
        instantB = Instant.now();
        Duration betterRun = Duration.between(instantA, instantB);

        System.out.println("bruteRun = " + bruteRun);
        System.out.println("betterRun = " + betterRun);
        assertTrue(bruteRun.toNanos() > betterRun.toNanos());
    }

    private static List<Integer> produceRandomizedArrayOfIntegers(int n) {
        int min = 1;
        int max = Integer.MAX_VALUE;
        Random random = new Random();

        List<Integer> results = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            results.add(random.nextInt(max - min + 1) + min);
        }

        return results;
    }
}
