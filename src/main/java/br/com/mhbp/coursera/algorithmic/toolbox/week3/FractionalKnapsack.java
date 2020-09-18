package br.com.mhbp.coursera.algorithmic.toolbox.week3;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        Item[] items = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, (i1, i2) ->
                Double.compare(  ( (double) i2.value/i2.weight), ((double) i1.value/i1.weight))
        );

        double value = 0;

        for (Item item : items) {
            if (capacity > 0) {
                double fraction = Math.min(item.weight, capacity);
                value +=  (double) item.value / (double) item.weight * fraction;
                capacity -= fraction;
            }
        }

        return value;
    }

    static class Item {
        int value;
        int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
