package br.com.mhbp.codility._2_arrays;

import java.util.Random;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int N = 7;
//        int[] array = new int[N];

        int[] array = { 9, 3, 9, 3, 9, 7, 6 };
        int[] arrayPair = { 0, 0, 0, 0, 0, 0, 0 };

        int indexLookingFor = 0;
        for (int index = 1; index < N / 2; ) {

            if (array[index] == array[indexLookingFor]) {
                arrayPair[index] = 1;
                array[index++] = 1;

                while(index < N / 2 && arrayPair[index] == 1) index++;
            }
        }

        int valueWithouPair = -1;

        for (int index = 1; index < N ; index++) {

            if (arrayPair[index] == 0) {
                valueWithouPair = array[index];
                break;
            }
        }

        System.out.println("valueWithouPair: " + valueWithouPair);
    }

    public void n(int N, int[] array) {
        Random random = new Random();

        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt();
            System.out.println(array[i]);
        }
    }
}
