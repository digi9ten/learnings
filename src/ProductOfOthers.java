public class ProductOfOthers {

    /*
     * Complete the process function below.
     */
    static long[] process(long[] input) {
        int index, otherIndex, arrLen = input.length;
        long[] left = new long[arrLen];
        long[] right = new long[arrLen];
        long[] prod = new long[arrLen];

        left[0] = 1L;
        right[arrLen - 1] = 1L;

        for (index = 1; index < arrLen; index++) {
            left[index] = input[index - 1] * left[index - 1];
        }

        for (otherIndex = arrLen - 2; otherIndex >= 0; otherIndex--) {
            right[otherIndex] = input[otherIndex + 1] * right[otherIndex + 1];
        }

        for (index = 0; index < arrLen; index++) {
            prod[index] = left[index] * right[index];
        }

        return prod;
    }

    public static void main(String[] args) {
        long[] array = new long[]{3, 5, 11};
        long[] result = ProductOfOthers.process(array);
        Util.printNumbers("Products of others (should be 55, 33, 15)", result);

        array = new long[]{32, 40, 13, 9};
        result = ProductOfOthers.process(array);
        Util.printNumbers("Products of others (should be 4680, 3744, 11520, 16640)", result);
    }
}