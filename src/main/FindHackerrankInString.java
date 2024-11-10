package main;

import java.util.Arrays;

public class FindHackerrankInString {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String hackerrankInString(String s) {
        char[] keyAsArray = "hackerrank".toCharArray();
        char[] incoming = null == s ? "".toCharArray() : s.toCharArray();

        char[] foundItems = new char[keyAsArray.length];
        int lastFind = 0;

        for (int outer = 0; outer < keyAsArray.length; outer++) {
            char currentOuterCh = keyAsArray[outer];

            for (int inner = lastFind; inner < incoming.length; inner++) {
                char currentInnerCh = incoming[inner];
                if (currentInnerCh == currentOuterCh) {
                    lastFind = ++inner;
                    foundItems[outer] = currentInnerCh;
                    break;
                }
            }

            boolean test = Arrays.equals(keyAsArray, foundItems);
            if (test) return "YES";
        }

        return "NO";
    }
}