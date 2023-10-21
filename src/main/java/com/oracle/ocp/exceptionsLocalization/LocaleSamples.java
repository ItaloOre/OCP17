package com.oracle.ocp.exceptionsLocalization;

import java.util.Locale;

public class LocaleSamples {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);//es_ES language, contry ..... minuscula,mayuscula

        System.out.println(Locale.GERMAN);
        System.out.println(Locale.GERMANY);

        Locale locale2 = new Locale.Builder()
                .setLanguage("es")
                .setLocale(Locale.US)
                .build();

        System.out.println(locale2);

    }
}
