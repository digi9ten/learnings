package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Assuming you are using the Gregorian calendar, find all leap years within a given range of years.
 * <p>
 * <p>
 * Every year that is exactly divisible by four is a leap year, except for years that are exactly divisible by 100,
 * but these centurial years are leap years if they are exactly divisible by 400. For example, the years 1700, 1800,
 * and 1900 are not leap years, but the year 2000
 *
 * @apiNote https://en.wikipedia.org/wiki/Gregorian_calendar
 */
public class FindLeapYears {

    public static List<Integer> findLeapYears(Integer start, Integer end) {
        if (start == null) {
            throw new IllegalArgumentException("start is missing");
        } else if (null == end)
            end = start;
        else if (end < start) {
            throw new IllegalArgumentException("start cannot be larger than end");
        }

        List<Integer> results = new ArrayList<Integer>();

        Integer currentYear = start;
        do {
            if (0 == currentYear % 400 || (0 == currentYear % 4 && 0 != currentYear % 100))
                results.add(currentYear);

        } while (currentYear++ <= end);

        return results;
    }
}
