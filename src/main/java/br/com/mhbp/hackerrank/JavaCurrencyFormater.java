package br.com.mhbp.hackerrank;

import java.util.Locale;

import static java.text.NumberFormat.getCurrencyInstance;

public class JavaCurrencyFormater {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
        double payment = 12324.134;
//        scanner.close();

        // Write your code here.
        String us =  getCurrencyInstance(Locale.US).format(payment);
        System.out.println("US: " + us);
        String india =  getCurrencyInstance(new Locale("en", "IN")).format(payment);
        System.out.println("India: " + india);
        String china =  getCurrencyInstance(Locale.CHINA).format(payment);
        System.out.println("China: " + china);
        String france =  getCurrencyInstance(Locale.FRANCE).format(payment);
        System.out.println("France: " + france);
    }
}
