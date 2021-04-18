package br.com.mhbp.coursera.ds.w1;

import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());
        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
                numbers.offer(value);
            } else if ("pop".equals(operation)) {
                Integer popped = stack.pop();
                numbers.remove(popped);
            } else if ("max".equals(operation)) {

                System.out.println(numbers.peek());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
