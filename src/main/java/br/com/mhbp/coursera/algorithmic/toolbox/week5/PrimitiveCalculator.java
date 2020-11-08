//package br.com.mhbp.coursera.algorithmic.toolbox.week5;

import java.util.*;

public class PrimitiveCalculator {

    private static List<Integer> optimal_sequence(int number) {

        List<Integer> dp = new ArrayList<>();
        dp.add(-1);
        dp.add(0);

        List<Integer> array = new ArrayList<>();
        array.add(0);
        array.add(1);


        for (int i = 2; i < number + 1; i++) {

            int count1 = dp.get(i - 1);
            int count2 = i % 2 == 0 ? dp.get(i / 2) : number;
            int count3 = i % 3 == 0 ? dp.get(i / 3) : number;

            dp.add(Math.min(count1, Math.min(count2, count3)) + 1);

            if (count3 <= Math.min(count2, count1))
                array.add(i/3);
            else if (count2 <= Math.min(count3, count1))
                array.add(i/2);
            else if (count1 <= Math.min(count3, count2))
                array.add(i-1);
        }

        List<Integer> array2 = new ArrayList<>();
        array2.add(number);

        int max = dp.get(number);

        for (int i = 0; i < max; i++) {
            array2.add(array.get(number));
            number = array.get(number);
        }


        Collections.reverse(array2);
        return array2;
    }
    

    private static List<Integer> optimal_sequence_greedy(int n) {

        List<Integer> sequence = new ArrayList<Integer>();

        while (n >= 1) {
            sequence.add(n);

            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }

        Collections.reverse(sequence);

        return sequence;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

