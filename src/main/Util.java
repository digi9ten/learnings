package main;

import java.util.Arrays;

public class Util {

    /**
     * This exists solely because you can't call a vararg function with primitive arrays.
     */
    public static void printNumbers(String prefix, int[] numbers) {
        Integer[] nuArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        printThese(prefix, nuArray);
    }

    public static void printNumbers(String prefix, long[] numbers) {
        Long[] nuArray = Arrays.stream(numbers).boxed().toArray(Long[]::new);
        printThese(prefix, nuArray);
    }

    @SafeVarargs
    public static <T> void printThese(String prefix, T... items) {
        StringBuilder result = new StringBuilder(prefix + " : ");
        for (int index = 0; index <= items.length - 1; index++) {
            result.append(items[index]);
            if (index < items.length - 1)
                result.append(", ");
        }
        System.out.println(result);
    }
}
