package br.com.mhbp.datastructure.heap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<Swap>();
        for (int i = data.length/2; i >= 0 ; --i) {
            siftDown(data, i, swaps);
        }
    }

    private int parent(int i) {
        return i/2;
    }

    private void siftUp(int[] data, int i) {
        while (i > 0 && data[parent(i)] > data[i]) {
            int tmp = data[parent(i)];
            data[parent(i)] = data[i];
            data[i] = tmp;
            i = parent(i);
        }
    }
    
    private void siftDown(int[] data, int i, List<Swap> swaps) {
        int leftChild = (2 * i) + 1;
        int rightChild = (2 * i) + 2;

        int minIndex = i;
        if (leftChild < data.length && data[leftChild] < data[minIndex]) {
            minIndex = leftChild;
        }

        if (rightChild < data.length && data[rightChild] < data[minIndex]) {
            minIndex = rightChild;
        }

        if (i != minIndex) {

            swaps.add(new Swap(i, minIndex));
            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
            siftDown(data, minIndex, swaps);
        }
    }
    // 5 2 3 4 1
    // 2 5 3 4 1

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}