package main;

import java.time.Duration;
import java.time.Instant;

public class Fibonacci {

    private static int fib(int n) {
        if (0 == n || 1 == n) return n;
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibWithMemo(int n, int[] memo) {
        if (0 == n || 1 == n) return n;
        else if (0 == memo[n]) {
            memo[n] = fibWithMemo(n - 1, memo) + fibWithMemo(n - 2, memo);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Instant instantA = Instant.now();
        int fibResult = fib(45);
        Instant instantB = Instant.now();
        Duration nonMemoRun = Duration.between(instantA, instantB);
        System.out.println("Non-Memoized Run of Fib of 45: " + fibResult + " took " + nonMemoRun.toMillis());

        int[] memo = new int[46];
        memo[0] = 0;
        memo[1] = 1;
        instantA = Instant.now();
        fibResult = fibWithMemo(45, memo);
        instantB = Instant.now();
        Duration memoRun = Duration.between(instantA, instantB);
        System.out.println("Memoized Run of Fib of 45: " + fibResult + " took " + memoRun.toMillis());
    }
}
