package main;

import java.util.Arrays;

/**
 * For given list of inputs, and channels find the maximum quality that would be achievable
 * with input values distribution over the channels.
 * Quality is measured as <b>the sum of medians of the distributed sub lists on each channel</b>.
 * Rule: each channel must have at least one element.
 * <p/>
 * Example:
 * Input: 1,2,3,4,5
 * Channels: 2
 * <br/>
 * A possible combinations of configurations is:
 * <br/>
 * Channel 1: 1,2,3,4 - Median: (2+3)/2 = 2.5
 * <br/>
 * Channel 2: 5 - Median: 5
 * <br/>
 * Resulting Median: 2.5 + 5 = 7.5. Rounds up to 8.
 * <p/>
 * This is an Amazon interview question.
 */
public class FindMaximumQualityOverChannels {

    public static double highestQuality(int[] numbers, int ch) {
        // Sort
        Arrays.sort(numbers);

        // what if the # of channels is equivalent to the input?
        if (numbers.length == ch) {
            return numbers[numbers.length - 1];

        } else {
            int sum = 0;
            int index = numbers.length - 1;
            while (ch > 1) {
                sum += numbers[index];
                index--;
                ch--;
            }

            int middleMark = index / 2;
            double median = (double) (numbers[middleMark] + numbers[middleMark + 1]) / 2;

            return median + sum;
        }
    }
}
