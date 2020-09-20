package br.com.mhbp.coursera.algorithmic.toolbox.week4;

import java.util.*;
import java.io.*;

public class MajorityElement {


    public static void main(String[] args) {

        Random random = new Random();
        while (true) {
            int n = Math.abs(random.nextInt() % 10 + 2);
            System.out.println(" Array tamanho: " + n);
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = random.nextInt() % 100_000;
                System.out.print(array[i] + " ");
            }
            System.out.println();
            int r1 = getMajorityElement(array, 0, n);
            int r2 = getMajorityElement_Quadratic(array, 0, n);

            if (r1 != r2) {
                System.out.println("Wrong answer :" + r1 + " " + r2);
                break;
            } else {
                System.out.println("OK");
            }

        }
    }


    private static int getMajorityElement_Quadratic(int[] a, int left, int right) {

        for (int i = left; i < right; i++) {
            int count = 0;
            int current = a[i];
            for (int j = left; j < right; j++) {

                if (a[j] == current) count++;
            }

            if ( count > a.length / 2 ) {
                return current;
            }
        }
        return  -1;
    }

    private static int getMajorityElement(int[] a, int left, int right) {

        if (left == right) { //empty range
            return -1;
        }

        if (left + 1 == right) { // range of single element
            return a[left];
        }

        Arrays.sort(a);

        int i = left ;

        while( i < right - 1) {

            int count = 0;

            if (a[i] == a[i + 1]) {

                while (i < right - 1 && a[i] == a[i + 1]) {
                    i++;
                    count++;
                }

                if (count + 1  > a.length/2) {
                    return  a[i];
                }
            } else {
                i++;
            }

        }

        return -1;
    }


    private static int getMajorityElement_Old(int[] a, int left, int right) {
        //rigth == a.length
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }

        Arrays.sort(a);

        int i = left;
   ///0-9 /    0    10  ->   i = 9
        while( i < right - 1) {

            if (a[i] == a[i + 1]) {
                int count = 2;
                i++;

                while(i < right - 1 && a[i] == a[i + 1]) {
                    i++;
                    count++;
                }

                if ( count >=  a.length / 2)
                {
                    return count;
                }

            }
            i++;
        }
        //write your code here
        return -1;
    }

    public static void mainOriginal(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

