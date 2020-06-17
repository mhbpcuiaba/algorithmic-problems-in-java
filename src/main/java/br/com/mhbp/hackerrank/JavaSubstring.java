package br.com.mhbp.hackerrank;


public class JavaSubstring {


    public static void main(String[] args) {
        String str = "anana";
        String str2 = "banana";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder input1 = new StringBuilder(s);
        return s.equals(input1.reverse().toString());

    }
}
