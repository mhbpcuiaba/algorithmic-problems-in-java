package br.com.mhbp.dynamic.programming.knapsack.pattern.knapsack01;

public class Knapsak_0_1 {

    public static void main(String[] args) {
        Item[] items = new Item[5];

        items[0] = new Item(3, 70);
        items[1] = new Item(1, 20);
        items[2] = new Item(2, 35);
        items[3] = new Item(6, 80);
        items[4] = new Item(5, 60);

        Knapsak_0_1 knapsak_0_1 = new Knapsak_0_1(7, items);
        knapsak_0_1.print();
    }
    int weightCapacity;
    Item[] items;
    int[][] matrizSolution;
    int numberOfItems;

    public Knapsak_0_1(int weightCapacity, Item[] items) {

        if (weightCapacity < 1 || items == null || items.length == 0)
            throw new IllegalStateException("weight capacity must be greater than 0 and items cannot be empty. In these cases the result is 0");

        this.weightCapacity = weightCapacity;
        this.items = items;
        this.numberOfItems = items.length;
        this.matrizSolution = new int [this.items.length + 1][weightCapacity + 1];
    }

    public void print() {
        for (int i = 0; i < this.items.length + 1; i++) {
            for (int j = 0; j < weightCapacity + 1; j++) {
                System.out.print(matrizSolution[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int recursiveSolution(int indexItem, int currentCapacity) {

        if (indexItem == 0 || currentCapacity == 0) {
            return 0;
        }
        else if (items[indexItem].weight > currentCapacity) {
            return recursiveSolution(indexItem - 1, currentCapacity);
        } else {
            int tpm1 = recursiveSolution(indexItem - 1, currentCapacity);
            int tpm2 = recursiveSolution(indexItem - 1, currentCapacity - items[indexItem - 1].weight);
            return Math.max(tpm1, tpm2);
        }
    }

    public int dynamiProgrammingSolution() {
        this.matrizSolution = new int [this.items.length + 1][weightCapacity + 1];
        return 0;
    }
    static class Item {
        int weight; int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
