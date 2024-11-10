package main;

import java.util.List;

public class GetTotalX {
    /*
     * Complete the 'getTotalX' function below.
     *
     * Simplest breakdown - https://www.hackerrank.com/challenges/between-two-sets/forum/comments/1458622
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;

        int result = a.getFirst();
        for (int index = 1; index < a.size(); index++) {
            result = lcm(result, a.get(index));
        }

        int gcdB = b.getFirst();
        for (int index = 1; index < b.size(); index++) {
            gcdB = gcd(gcdB, b.get(index));
        }

        for (int x = result; x <= gcdB; x += result) {
            if (gcdB % x == 0) {
                count++;
            }
        }

        return count;
    }

    /**
     * greatest common divisor between a and b
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        while (0 != b) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * least common multiplier
     *
     * @param a
     * @param b
     * @return
     */
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}