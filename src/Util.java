class Util {

    static void printNumbers(String prefix, int[] numbers) {
        StringBuilder result = new StringBuilder(prefix + " : ");
        for (int index = 0; index <= numbers.length - 1; index++) {
            result.append(numbers[index]);
            if (index < numbers.length - 1)
                result.append(", ");
        }
        System.out.println(result.toString());
    }

    static void printChars(String prefix, char[] chars) {
        StringBuilder result = new StringBuilder(prefix + " : ");
        for (int index = 0; index <= chars.length - 1; index++) {
            result.append(chars[index]);
            if (index < chars.length - 1)
                result.append(", ");
        }
        System.out.println(result.toString());
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
