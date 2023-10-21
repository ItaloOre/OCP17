package com.oracle.ocp.exceptionsLocalization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DecimalFormatSamples {

    public static void main(String[] args) {
        double d = 1234.567;
        NumberFormat f1 = new DecimalFormat("###,###,###.00");
        System.out.println(f1.format(d)); // 1,234.60

        NumberFormat f2 = new DecimalFormat("000,000,000.00000");
        System.out.println(f2.format(d)); // 000,001,234.56700

        NumberFormat f3 = new DecimalFormat("Your Balance $#,###,###.##");
        System.out.println(f3.format(d)); // Your Balance $1,234.57

        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
        System.out.println(date.getDayOfWeek()); // THURSDAY
        System.out.println(date.getMonth()); // OCTOBER
        System.out.println(date.getYear()); // 2022
        System.out.println(date.getDayOfYear()); // 293

        LocalDate date1 = LocalDate.of(2022, Month.OCTOBER, 20);
        LocalTime time1 = LocalTime.of(11, 12, 34);
        LocalDateTime dt1 = LocalDateTime.of(date1, time1);
        System.out.println(date1.format(DateTimeFormatter.ISO_LOCAL_DATE));
        //System.out.println(date1.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        System.out.println(time1.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dt1.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(dt1.format(DateTimeFormatter.ISO_LOCAL_TIME));
        //System.out.println(date1.format(DateTimeFormatter.ISO_LOCAL_TIME)); CUIDADO CON EL UNSUPPORTER

        var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(dt1.format(f)); // October 20, 2022 at 11:12
    }
}


