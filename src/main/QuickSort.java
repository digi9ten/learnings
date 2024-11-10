package main;

public class QuickSort {

    private static void swap(int[] numbers, int indexA, int indexB) {
        int tmp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = tmp;
    }

    private static int partition(int[] numbers, int left, int right) {
        int pivot = numbers[right];
        int lowestValIndex = (left - 1);

        // moving items smaller than pivot to the left...
        for (int index = left; index <= right - 1; index++) {
            if (numbers[index] <= pivot) {
                lowestValIndex++;
                swap(numbers, lowestValIndex, index);
            }
        }

        // we've found a new lower value...
        lowestValIndex++;
        // swap that and the current pivot...
        swap(numbers, lowestValIndex, right);

        return lowestValIndex;
    }

    private static void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            int piv = partition(numbers, left, right);

            quickSort(numbers, left, piv - 1);
            quickSort(numbers, piv + 1, right);
        }
    }

    private static void runSortAndPrintResults(int[] numbers) {
        Util.printNumbers("Starting Values", numbers);
        quickSort(numbers, 0, numbers.length - 1);
        Util.printNumbers("Final main.Result", numbers);
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    protected ListNode deleteDuplicates(ListNode node) {
        ListNode a = node, b;

        while (null != a && null != a.next) {
            b = a;
            while (null != b.next) {
                if (a.val == b.next.val) {
                    b.next = b.next.next;
                } else {
                    b = b.next;
                }
            }
            a = a.next;
        }
        return node;
    }
}
