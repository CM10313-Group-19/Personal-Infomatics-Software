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
            //if timeDate2 is less than timeDate1, add 24 hours to timeDate2
            if (timeDate2.getTime() < timeDate1.getTime()){
                timeDate2.setTime(timeDate2.getTime() + 86400000);
            }
            if(timeDate1.getTime() == timeDate2.getTime()){
                return "00:00";
            }
            //if either time is not in 24hr format, return 00:00
            if (!validateTimeInput(timeString1) || !validateTimeInput(timeString2)){
                return "00:00";
            }

            long calculateMS = Math.abs(timeDate2.getTime() - timeDate1.getTime()); // time in milliseconds for conversions

            long calculateHours = (calculateMS / (60 * 60 * 1000)) % 24; // hours

            long calculateMins = (calculateMS / (60 * 1000)) % 60; // minutes

            //if mins is less than 10, add a 0 to the front
            String calculateMinsString = Long.toString(calculateMins);
            if (calculateMins < 10){
                calculateMinsString = "0" + calculateMinsString;
            }
            String calculateHoursString = Long.toString(calculateHours);
            if (calculateHours < 10){
                calculateHoursString = "0" + calculateHoursString;
            }
            //if length of either part is greater than 2, return 00:00
            if (calculateHoursString.length() > 2 || calculateMinsString.length() > 2){
                return "00:00";
            }
            //if length of either part is less than 2, add a 0 to the front
            if (calculateHoursString.length() < 2){
                calculateHoursString = "0" + calculateHoursString;
            }
            if (calculateMinsString.length() < 2){
                calculateMinsString = "0" + calculateMinsString;
            }

            return calculateHoursString + ":" + calculateMinsString;
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

    //Checks for a valid distance which may contain 1 decimal point
    public static boolean validateDistanceInput(String userDistanceInput){
        Pattern distanceFormat = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$");
        Matcher distanceMatcher = distanceFormat.matcher(userDistanceInput);
        return distanceMatcher.matches();

    }

    //turns a 24hr time into the number of minutes since midnight
    public static int calculateMinutes(String timeString){
        SimpleDateFormat format24HRS = new SimpleDateFormat("HH:mm");
        try {
            Date timeDate = format24HRS.parse(timeString);
            int hours = timeDate.getHours();
            int minutes = timeDate.getMinutes();
            return (hours * 60) + minutes;
        }
        catch (ParseException e) {
            return 0;
        }
    }
}
