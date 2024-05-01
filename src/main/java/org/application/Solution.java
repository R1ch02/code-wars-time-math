package org.application;

//Given two times in hours, minutes, and seconds (ie '15:04:24'), add or subtract them.
//This is a 24 hour clock. Output should be two digits for all numbers: hours, minutes, seconds (ie '04:02:09').
//
// timeMath('01:24:31', '+', '02:16:05') === '03:40:36'
//
// timeMath('01:24:31', '-', '02:31:41') === '22:52:50'


public class Solution
{
    public static String timeMath(final String time1, final String op, final String time2)
    {
        int hours = 0, minutes = 0, seconds = 0;
        String result = "";
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");
        if (op.equals("+")) {
            hours = Integer.parseInt(parts1[0]) + Integer.parseInt(parts2[0]);
            minutes = Integer.parseInt(parts1[1]) + Integer.parseInt(parts2[1]);
            seconds = Integer.parseInt(parts1[2]) + Integer.parseInt(parts2[2]);
            if (seconds > 59) {
                seconds-=60;
                minutes++;
            }
            if (minutes > 59) {
                minutes-=60;
                hours++;
            }
            if (hours >= 24) {
                hours-=24;
            }
        } else if (op.equals("-")) {

            hours = Integer.parseInt(parts1[0]) - Integer.parseInt(parts2[0]);
            minutes = Integer.parseInt(parts1[1]) - Integer.parseInt(parts2[1]);
            seconds = Integer.parseInt(parts1[2]) - Integer.parseInt(parts2[2]);
            if (seconds < 0) {
                seconds+=60;
                minutes--;
            }
            if (minutes < 0) {
                minutes+=60;
                hours--;
            }
            if (hours < 0) {
                hours+=24;
            }
        }
        if (hours < 10) {
            result+= "0" + hours + ":";
        }  else {
            result+= "" + hours + ":";
        }
        if(minutes < 10) {
            result+= "0" + minutes + ":";
        } else {
            result+= "" + minutes + ":";
        }
        if (seconds < 10) {
            result+= "0" + seconds;
        }   else {
            result+= "" + seconds;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(timeMath("01:24:31", "+", "02:16:05"));
    }
}



