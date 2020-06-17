package br.com.mhbp.arrays_primitives_strings.strings;

import java.util.Map;

public class ReverseWords {


    public void reverseWords(char[] input) {

        int n = input.length;

        //first, reverses the whole string.
        reverse(input, 0, input.length - 1);

        int start = 0, finish = 0;

        while ( start < n ) {

            //skip white spaces
            while (start < finish || start < n && input[start] == ' ') start++;

            while (finish < start || finish < n && input[finish] != ' ') finish++;

            reverse(input, start, finish - 1);
        }
    }

    private void reverse(char[] array, int start, int end) {

        while (start < end) {
            char tmp = array[start];
            array[start++] = array[end];
            array[end--] = tmp;
        }
    }
}
