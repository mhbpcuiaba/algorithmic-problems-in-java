package br.com.mhbp.hackerrank;

public class JavaStringsIntroduction {

    public static void main(String[] args) {
        String a = "java";
        String b = "java";

        System.out.println(a.length() + b.length());


        System.out.println(a.compareTo(b) <= 0 ? "No":"Yes");

        System.out.println(capitalize(a) + " " + capitalize(b));
    }
    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
