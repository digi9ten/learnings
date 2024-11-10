package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the
 * Programmer (the 256th day of the year) during a year in the inclusive range from 1700 to 2700.
 * <br/>
 * <p>
 * From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the
 * Gregorian calendar system. The transition from the Julian to Gregorian calendar system occurred in 1918,
 * when the next day after January 31st was February 14th. This means that in 1918, February 14th was
 * the 32nd day of the year in Russia.
 * <br/>
 * <p>
 * In both calendar systems, February is the only month with a variable amount of days; it has 29 days
 * during a leap year, and 28 days during all other years. In the Julian calendar, leap years are
 * divisible by 4; in the Gregorian calendar, leap years are either of the following:
 * <ul>
 *     <li>Divisible by 400</li>
 *     <li>Divisible by 4 and not divisible by 100</li>
 * </ul>
 * <br/>
 * <p>
 * Given a year, <i>y</i>, find the date of the 256th day of that year according to the official Russian calendar
 * during that year. Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is
 * the two-digit month, and yyyy is <i>y</i>.
 */
public class DayOfProgrammer {

    /*
     * Complete the 'findDOPForYear' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
    public static String findDOPForYear(int year) {
        if(year < 0)
            throw new IllegalArgumentException("year must be a positive number");

        LocalDate ld = LocalDate.ofYearDay(year, 256);

        if (1918 == year) {
            ld = ld.plusDays(13);
        } else if (year < 1918) {
            if (0 == year % 4 && 0 == year % 100) {
                ld = ld.minusDays(1);
            }
        } else {
            if (0 == year % 400 || (0 == year % 4 && 0 != year % 100)) {

            } else {

            }
        }

        String result = ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(result);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(System.console().writer());

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = DayOfProgrammer.findDOPForYear(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
