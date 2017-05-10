package com.logic;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kien Warren on 5/8/17.
 */
public class DateManipulator {

    /**
     * Gets next occurring Date. If the recurrenceDay is set to today, it will grab the next week's day.
     *
     * @param time          the time
     * @param recurrenceDay the recurrence day
     * @return the date
     */
    public static Date nextDateTime(int time, String recurrenceDay) {
        Date now = new Date();
        Calendar date1 = Calendar.getInstance();
        date1.setTime(now);
        date1.add(Calendar.DATE, 1);

        switch (recurrenceDay) {
            case "M":
                while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                    date1.add(Calendar.DATE, 1);
                }
                break;
            case "T":
                while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.TUESDAY) {
                    date1.add(Calendar.DATE, 1);
                }
                break;
            case "W":
                while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.WEDNESDAY) {
                    date1.add(Calendar.DATE, 1);
                }
                break;
            case "R":
                while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.THURSDAY) {
                    date1.add(Calendar.DATE, 1);
                }
                break;
            case "F":
                while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY) {
                    date1.add(Calendar.DATE, 1);
                }
                break;
            case "S":
                while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                    date1.add(Calendar.DATE, 1);
                }
                break;
            case "N":
                while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    date1.add(Calendar.DATE, 1);
                }
                break;
        }

        date1.getTimeInMillis();
        Date then = new Date(date1.getTimeInMillis());
        return then;
    }
}
