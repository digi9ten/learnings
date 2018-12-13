public class ClockByAngles {

    private static int calculate(float hours, float minutes) {
        if (12 == hours) hours = 0;
        if (60 == minutes) minutes = 0;

        int hour_angle = (int) (0.5 * (hours * 60 + minutes));
        int minute_angle = (int) (6 * minutes);

        int angle = Math.abs(hour_angle - minute_angle);
        return Math.min(360 - angle, angle);
    }

    public static void main(String[] args) {
        int angle = calculate(9, 60);
        System.out.println("For 9:00 it should be 90: " + angle);

        angle = calculate(3, 30);
        System.out.println("For 3:30 it should be 75: " + angle);

        angle = calculate(2, 15);
        System.out.println("For 2:15 it should be 23: " + angle);

        angle = calculate(12, 45);
        System.out.println("For 12:45 it should be 112: " + angle);

        angle = calculate(11, 45);
        System.out.println("For 11:45 it should be 82: " + angle);
    }
}
