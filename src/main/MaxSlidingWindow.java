package main;

import java.util.ArrayDeque;

public class MaxSlidingWindow {

    private static ArrayDeque<Integer> findMaxSlidingWindow(int[] array, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        int maxFound = 0;

        for (int index = 1; index < array.length; index++) {
            if (array[index] > array[maxFound]) {
                maxFound = index;
            }

            result.addLast(array[index]);

            if (result.size() > windowSize) {
                result.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 3, 2, 1, 2, 5};
        int windowSize = 4;
        ArrayDeque<Integer> result = findMaxSlidingWindow(numbers, windowSize);
        Util.printThese("sliding window (should be [2, 1, 2, 5])", result.toArray());

        windowSize = 3;
        result = findMaxSlidingWindow(numbers, windowSize);
        Util.printThese("sliding window (should be [1, 2, 5])", result.toArray());

        windowSize = 5;
        result = findMaxSlidingWindow(numbers, windowSize);
        Util.printThese("sliding window (should be [3, 2, 1, 2, 5])", result.toArray());
    }
}