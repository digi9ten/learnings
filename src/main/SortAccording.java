package main;

import java.util.Arrays;
import java.util.Comparator;

public class SortAccording {

    private static int compareWords(String a, String b, String[] ordering) {
        char[] charsFromA = a.toCharArray();
        char[] charsFromB = b.toCharArray();
        int shortestString = Math.min(charsFromA.length, charsFromB.length);

        for (int index = 0; index < shortestString; index++) {
            char charFromA = charsFromA[index];
            char charFromB = charsFromB[index];
            if (charFromA == charFromB) continue;

            for (String orderElement : ordering) {
                if (orderElement.equals(String.valueOf(charFromA))) {
                    return -1;
                } else if (orderElement.equals(String.valueOf(charFromB))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private static boolean verify(String[] words, final String[] ordering) {
        String[] copyOf = Arrays.copyOf(words, words.length);
        Comparator<String> comparator = (a, b) -> compareWords(a, b, ordering);
        Arrays.sort(copyOf, comparator);
        return Arrays.equals(words, copyOf);
    }

    public static void main(String[] args) {
        String[] words;
        String[] ordering;

        words = new String[]{"cc", "cb", "bc", "ac"};
        ordering = new String[]{"c", "b", "a"};
        Util.printThese("Ordering", ordering);
        Util.printThese("Words", words);
        System.out.println("Was is Order (should be true)? " + verify(words, ordering));

        ordering = new String[]{"b", "c", "a"};
        Util.printThese("Ordering", ordering);
        Util.printThese("Words", words);
        System.out.println("Was is Order (should be false)? " + verify(words, ordering));

        ordering = new String[]{"y", "d", "o"};

        words = new String[]{"cc", "cz", "ax", "lmn"};
        Util.printThese("Ordering", ordering);
        Util.printThese("Words", words);
        System.out.println("Was is Order (should be true)? " + verify(words, ordering));

        words = new String[]{"ydo", "yyy", "ydy", "ooy", "ody"};
        Util.printThese("Ordering", ordering);
        Util.printThese("Words", words);
        System.out.println("Was is Order (should be false)? " + verify(words, ordering));

        words = new String[]{"yyy", "ydy", "ydo", "ody", "ooy"};
        Util.printThese("Ordering", ordering);
        Util.printThese("Words", words);
        System.out.println("Was is Order (should be true)? " + verify(words, ordering));
    }
}
