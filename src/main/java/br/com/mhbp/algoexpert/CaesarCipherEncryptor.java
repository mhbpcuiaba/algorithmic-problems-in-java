package br.com.mhbp.algoexpert;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {

        // a=97
        //z=122
        //A=65
        //Z=90

//        System.out.println( (int) 'a');
//        System.out.println( (int) 'z');
//        System.out.println();
//        System.out.println( (int) 'A');
//        System.out.println( (int) 'Z');
//        System.out.println(caesarCypherEncryptor("xyz", 5));
        System.out.println(caesarCypherEncryptor("abc", 52));
    }
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            int tmp = chars[i] + key;


            while (tmp > 122) tmp =   ((int)'a' + tmp - 122 - 1);
            chars[i] = (char) tmp;
        }
        return new String(chars);
    }

}
