public class MergeSort {

    private static void mergeSort(int[] numbers, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(numbers, left, mid);
            mergeSort(numbers, mid + 1, right);

            merge(numbers, left, mid, right);
        }
    }

    private static void merge(int[] numbers, int left, int mid, int right) {
        int leftCount = 0, rightCount = 0, mergedIndex = left;

        int[] leftArray = new int[mid - left + 1];
        System.arraycopy(numbers, left, leftArray, 0, leftArray.length);

        int[] rightArray = new int[right - mid];
        System.arraycopy(numbers, mid + 1, rightArray, 0, rightArray.length);

        while (leftArray.length > leftCount && rightArray.length > rightCount) {
            int leftVal = leftArray[leftCount];
            int rightVal = rightArray[rightCount];
            if (leftVal <= rightVal) {
                numbers[mergedIndex++] = leftVal;
                leftCount++;
            } else {
                numbers[mergedIndex++] = rightVal;
                rightCount++;
            }
        }

        while (leftArray.length > leftCount) {
            numbers[mergedIndex++] = leftArray[leftCount++];
        }

        while (rightArray.length > rightCount) {
            numbers[mergedIndex++] = rightArray[rightCount++];
        }
    }

    private static void runSortAndPrintResults(int[] numbers) {
        Util.printNumbers("Starting Values", numbers);
        mergeSort(numbers, 0, numbers.length - 1);
        Util.printNumbers("Final Result", numbers);
    }

    public static void main(String[] args) {
        runSortAndPrintResults(new int[]{12, 11, 13, 5, 6, 7});

        runSortAndPrintResults(new int[]{38, 3, 82, 7, 10, 32, 11, 54});

        runSortAndPrintResults(new int[]{100, 40, 3, 2333, 32, -5, 72, 16, 92});

        runSortAndPrintResults(new int[]{1, 3, 5, 7, 2, 4, 6, 8});

        runSortAndPrintResults(new int[]{38, 27, 43, 3, 9, 82, 10});

        runSortAndPrintResults(new int[]{5, 2, 3, 7, 1});

        runSortAndPrintResults(new int[]{100, 40, 3, 56, 32, 19, 72, 16});
    }
}
