package main;

public class ClockByAngles {

    public static int calculate(float hours, float minutes) {
        if (12 == hours) hours = 0;
        if (60 == minutes) minutes = 0;

        int hour_angle = (int) (0.5 * (hours * 60 + minutes));
        int minute_angle = (int) (6 * minutes);

        int angle = Math.abs(hour_angle - minute_angle);
        return Math.min(360 - angle, angle);
    }
}
