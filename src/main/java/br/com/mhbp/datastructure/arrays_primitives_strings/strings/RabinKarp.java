package br.com.mhbp.datastructure.arrays_primitives_strings.strings;

public class RabinKarp {

    //O ( m + n)
    //returns the index of the first character of the substring if found,
    // otherwise returns -1
    public int rabinKarp(String text, String searchedPattern) {

        if (searchedPattern.length() > text.length())  return -1;

        int BASE = 26;
        int tHash = 0;
        int sHash = 0;
        int powerS = 1;

        for (int i = 0; i < searchedPattern.length(); i++) {
            powerS = i > 0 ? powerS * i:1;
            tHash = tHash * BASE + text.charAt(i);
            sHash = sHash * BASE + searchedPattern.charAt(i);
        }


        for (int i = 0; i < text.length(); i++) {

            if (tHash == sHash && text.substring(i - searchedPattern.length(), i).equals(searchedPattern)) {
                return i - searchedPattern.length();//found match
            }

            tHash -= text.charAt(i - searchedPattern.length()) * powerS;
            tHash = tHash * BASE + text.charAt(i);
        }

        if (tHash == sHash && text.substring(text.length() - searchedPattern.length()).equals(searchedPattern)) {
            return text.length() - searchedPattern.length();
        }

        return -1;
    }
}
