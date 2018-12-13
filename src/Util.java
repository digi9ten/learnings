import java.util.Arrays;

class Util {

    /**
     * This exists solely because you can't call an vararg function with primitive arrays.
     *
     * @param prefix
     * @param numbers
     */
    static void printNumbers(String prefix, int[] numbers) {
        Integer[] nuArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        printThese(prefix, nuArray);
    }

    @SafeVarargs
    static <T> void printThese(String prefix, T... items) {
        StringBuilder result = new StringBuilder(prefix + " : ");
        for (int index = 0; index <= items.length - 1; index++) {
            result.append(items[index]);
            if (index < items.length - 1)
                result.append(", ");
        }
        System.out.println(result.toString());
    }
}
