package com.oracle.ocp.exceptionsLocalization.test;


import java.text.NumberFormat;
import java.util.Locale;

public class BookQ5 {

    /**
     A. 100
     B. $100,000.00
     C. 100K
     D. 100 thousand
     E. 100M
     F. $100,102.20
     G. None of the above
     */
    public static void main(String[] args) {
        print(100_102.2);
    }
    public static void print(double t) {
        System.out.println(NumberFormat.getCompactNumberInstance().format(t));
        System.out.println(
                NumberFormat.getCompactNumberInstance(
                        Locale.getDefault(), NumberFormat.Style.SHORT).format(t));
        System.out.println(NumberFormat.getCurrencyInstance().format(t));
    }
}
