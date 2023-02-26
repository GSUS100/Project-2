/**
 * Class for a Date and checking it is valid
 * @author Yehun Kim, Nelson Reyes
 */

import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public static final int MONTHS_IN_YEAR = 12;
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;
    public static final int JAN_MAR_MAY_JUL_AUG_OCT_DEC = 31;
    public static final int APR_JUN_SEP_NOV = 30;
    public static final int FEB_NON_LEAP_YEAR = 28;
    public static final int FEB_LEAP_YEAR = 29;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    public Date() {
        Calendar now = Calendar.getInstance();
        year = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH) + 1;
        day = now.get(Calendar.DAY_OF_MONTH);
    }

    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    /**
     *
     * @param date setting the year,month,and day
     */
    public Date(String date) {
        String[] dateArray = date.split("/");
        month = Integer.parseInt(dateArray[0]);
        day = Integer.parseInt(dateArray[1]);
        year = Integer.parseInt(dateArray[2]);
    }

    /**
     * isValid method to check the calendar has the valid dates.
     * @return false if it is invalid, day >=1 && day <=daysInMonth
     */
    public boolean isValid() {
        int DAYS_OF_MONTH;
        if (month < JANUARY || month > DECEMBER) {
            return false;
        }
        if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) {
            DAYS_OF_MONTH = APR_JUN_SEP_NOV;
        } else if (month == FEBRUARY) {
            if (isLeapYear()) {
                DAYS_OF_MONTH = FEB_LEAP_YEAR;
            } else {
                DAYS_OF_MONTH = FEB_NON_LEAP_YEAR;
            }
        } else {
            DAYS_OF_MONTH = JAN_MAR_MAY_JUL_AUG_OCT_DEC;
        }
        return day >= 1 && day <= DAYS_OF_MONTH;
    }

    /**
     * check the leapyear
     * @return true if it is a leapyear, false otherwise
     */
    private boolean isLeapYear() {
        if (year % QUADRENNIAL == 0) {
            if (year % CENTENNIAL == 0) {
                return year % QUATERCENTENNIAL == 0;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Date)) return false;
        Date d = (Date) obj;
        return d.year == year && d.month == month && d.day == day;
    }

    @Override
    public int compareTo(Date d) {
        if (year != d.year) return year - d.year;
        if (month != d.month) return month - d.month;
        return day - d.day;
    }

    /**
     * Testbed main to check isValid() works well
     * 5 tests cases for invalid calendar dates in Project1_TestCases.txt
     * I picked 5 test dates from the given file
     * @param args
     */
    public static void main(String[] args) {
        Date[] testDates = {
                new Date("9/2/2022"),
                new Date("1/2/2007"),
                new Date("2/29/2003"),
                new Date("4/31/2003"),
                new Date("3/32/2003"),
                new Date("4/3/2003"),
                new Date("1/20/2003"),
        };
        System.out.println("Testing (testbed main) validity of dates:");
        for (Date d : testDates) {
            System.out.println(d + " is valid: " + d.isValid());
        }
    }
}