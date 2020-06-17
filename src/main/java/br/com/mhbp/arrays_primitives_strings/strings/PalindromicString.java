package br.com.mhbp.arrays_primitives_strings.strings;

public class PalindromicString {


    public static void main(String[] args) {
        System.out.println(isPalindrome("abaaba"));
    }

    public static boolean isPalindrome(String str) {

        for (int i = 0; i < str.length()/2; i++) {

            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }

        return true;
    }

    public static boolean isPalindromicity(String str) {

       int left = 0;
       int right = str.length() - 1;

       while(left < right) {

           while (!Character.isLetterOrDigit(str.charAt(left)) && left < right) left++;
           while (!Character.isLetterOrDigit(str.charAt(right)) && left < right) right--;

           if (str.charAt(left++) != str.charAt(right--)) return  false;
       }
       return true;
    }
}
