package program.MainProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static String calculateTimeDifference(String timeString1, String timeString2){
        /** A bit broken atm cause cant work out time correctly **/
        SimpleDateFormat format24HRS = new SimpleDateFormat("HH:mm");
        try {
            Date timeDate1 = format24HRS.parse(timeString1);
            Date timeDate2 = format24HRS.parse(timeString2);
            System.out.println(timeDate1);
            System.out.println(timeDate2);

            long calculateMS = Math.abs(timeDate2.getTime() - timeDate1.getTime()); // time in milliseconds for conversions
            System.out.println(timeDate2.getTime());
            System.out.println(calculateMS);

            long calculateHours = (calculateMS / (60 * 60 * 1000)) % 24; // hours
            System.out.println(calculateHours);

            long calculateMins = (calculateMS / (60 * 1000)) % 60; // minutes
            System.out.println(calculateMins);

            return calculateHours + ":" + calculateMins;
        }
        catch (ParseException e) {
            return "00:00";
        }
    }

    public static boolean validateTimeInput(String userTimeInput){
        Pattern timeFormat = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]"); // regex pattern for 24hr time format
        Matcher timeMatcher = timeFormat.matcher(userTimeInput);
        return timeMatcher.matches();
    }

    /*Not sure if still needed
    public static long calculateMinutes(String timeString1, String timeString2){
        SimpleDateFormat format24HRS = new SimpleDateFormat("HH:mm");
        try {
            Date timeDate1 = format24HRS.parse(timeString1);
            Date timeDate2 = format24HRS.parse(timeString2);

            long calculateMS = Math.abs(timeDate2.getTime() - timeDate1.getTime()); // time in milliseconds for conversions
            long calculateMins = (calculateMS / (60 * 1000)) % 60; // minutes

            return calculateMins;
        }
        catch (ParseException e) {
            return 0;
        }
    }
     */
}
