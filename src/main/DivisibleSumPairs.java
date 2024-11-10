package main;

import java.util.*;

/**
 * You are given an array of n integers a0, a1, .. an and a positive integer k.
 * Find and print the number of pairs (i,j) where i<j and i+j is evenly divisible by k (Which is i+j % k == 0).
 * Hackerrank problem - <a href="https://www.hackerrank.com/challenges/divisible-sum-pairs/problem">...</a>.
 * <br>
 * Great explanation of the O(n) solution here - <a href="https://cs.stackexchange.com/a/60636">...</a>
 * <br/>
 * If you run the time tests, you can literally compare the result size produced between
 * the bruth force and the better versions.
 */
public class DivisibleSumPairs {

    /**
     * This solves it in O(n^2)
     */
    public static int bruteForceDivisibleSumPairs(int n, int k, List<Integer> ar) {
        int result = 0;

        if (n != ar.size())
            return result;

        // odd length array nothing to do here
        if (1 == n % 2)
            return result;

        for (int index = 0; index < n; index++) {
            Integer a = ar.get(index);
            for (int j = index + 1; j < n; j++) {
                Integer b = ar.get(j);
                if ((a + b) % k == 0)
                    result++;
            }
        }

        return result;
    }

    /**
     * This solves it in O(n) - using a frequency array
     */
    public static int betterDivisibleSumPairs(int n, int k, List<Integer> ar) {
        if (n != ar.size())
            return 0;

        // odd length array nothing to do here
        if (1 == n % 2)
            return 0;

        // Create a frequency array to count occurrences of all remainders when divided by k.
        Map<Integer, Integer> freq = new HashMap<>();

        Set<Integer> possibles = new HashSet<>();

        // Count occurrences of all remainders
        for (int i = 0; i < n; i++) {
            int rem = ((ar.get(i) % k) + k) % k;
            possibles.add(ar.get(i));

            Integer found = freq.get(rem);
            if (null == found) {
                found = 0;
            }

            freq.put(rem, ++found);
        }

        // Traverse input array and use freq[] to decide if given array can be divided in pairs
        for (int i = 0; i < n; i++) {
            // Remainder of current element
            int rem = ((ar.get(i) % k) + k) % k;

            // If remainder with current element divides k into two halves.
            if (k == 2 * rem) {
                // Then there must be even occurrences of such remainder
                if (1 == freq.get(rem) % 2) ;

                // If remainder is 0, then there must be two elements with 0 remainder
            } else if (0 == rem) {
                // Then there must be even occurrences of such remainder
                if (1 == freq.get(rem) % 2) ;

                // Else number of occurrences of remainder must be equal to number of occurrences of k - remainder
            } else {
                if (!freq.get(k - rem).equals(freq.get(rem))) ;
            }
        }

        return 1 + possibles.size();
    }
}
