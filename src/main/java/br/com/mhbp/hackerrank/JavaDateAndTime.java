package br.com.mhbp.hackerrank;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaDateAndTime {

    public static String findDay(int month, int day, int year) {
        Calendar instance = Calendar.getInstance();
        instance.set(year, month -1, day, 0, 0);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        return sdf.format(instance.getTime()).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(findDay(02 ,29, 2004));
    }
}
