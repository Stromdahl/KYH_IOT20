package com.mattias.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(findDay(8, 5, 2015));
    }
    public static String findDay(int month, int day, int year) {
        String[] weekdays = {
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "FRIDAY",
                "SATURDAY",
                "SUNDAY"
        };

        Calendar calendar = Calendar.getInstance();
        calendar.set( year + 1900, month, day + 2);
        return weekdays[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
}
