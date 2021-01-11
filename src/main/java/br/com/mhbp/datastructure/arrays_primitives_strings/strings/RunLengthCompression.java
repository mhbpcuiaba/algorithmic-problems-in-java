package br.com.mhbp.datastructure.arrays_primitives_strings.strings;

public class RunLengthCompression {

    public String decoding(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else {

                while (count > 0) {
                    sb.append(s.charAt(i));
                    count--;
                }
            }
        }
        return sb.toString();
    }

    public String encoding(String s) {
        String decoedString = null;

        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s.length(); i++) {

            if (i == s.length() || s.charAt(i) != s.charAt(i -1)) {
                sb.append(count).append(s.charAt(i - 1));
            } else {
                count++;
            }

        }
        return decoedString;
    }
}
