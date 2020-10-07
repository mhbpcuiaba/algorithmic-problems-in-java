//package br.com.mhbp.coursera.algorithmic.toolbox.week4;

import java.io.*;
import java.util.*;

/*
current Test case

5
2 3 9 2 9


[CURRENT]
5
-41851 85265 86257 -94086 -41851

11
1
ERROR ERROR


Array tamanho: 10

Input

-27164 99310 59285 53545 -7253 -7253 40247 -53683 -58018 -65998

ERROR ERROR
Array1
-65998 -58018 -53683 -27164 59285 -7253 -7253 40247 53545 99310
Array2
-65998 -58018 -53683 -27164 -7253 -7253 40247 53545 59285 99310



R1:

    -65998 -58018 -53683 -27164 -7253 40247 -7253 53545 59285 99310
R2:
    -65998 -58018 -53683 -27164 59285 -7253 -7253 40247 53545 99310
 */
public class Sorting {
    private static Random random = new Random();

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here

        int pivot =  a[l];
        int firstRepeat = l;
        int lastRepeat  = l;

        //                   ??

        for (int i = l + 1; i <= r; i++) {

            if (a[i] < pivot) {
                swap(a, i, lastRepeat + 1);
                swap(a, firstRepeat, lastRepeat + 1);
                lastRepeat++;
                firstRepeat++;
            } else if (a[i] == pivot) {
                swap(a, i, lastRepeat + 1);
                lastRepeat++;
            }


        }

        int[] m = {firstRepeat, lastRepeat};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        //swap
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        //

        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
//        int m = partition2(a, l, r);
        int[] rangeOfRepeated = partition3(a, l, r);

        randomizedQuickSort(a, l, rangeOfRepeated[0] - 1);
        randomizedQuickSort(a, rangeOfRepeated[1] + 1, r);
    }

    private static void randomizedQuickSort_partition2(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m = partition2(a, l, r);
        randomizedQuickSort_partition2(a, l, m - 1);
        randomizedQuickSort_partition2(a, m + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main_stress_test(String[] args) {

        Random random = new Random();
        while (true) {
            int n = Math.abs(random.nextInt() % 10 + 2);
            System.out.println(" Array tamanho: " + n);
            int[] array1 = new int[n];
            int[] array2 = new int[n];

            for (int i = 0; i < n; i++) {
                array1[i] = random.nextInt() % 100_000;
                array2[i] = array1[i];
                System.out.println("array1[" + i + "]" + array1[i] + " ");
                System.out.println("array2[" + i + "]" + array2[i] + " ");
            }

            randomizedQuickSort(array1, 0, n - 1);
            randomizedQuickSort_partition2(array2, 0, n - 1);

            if ( Arrays.equals(array1, array2)) {
                System.out.println();
                System.out.println("OK");
                System.out.println();
            } else {
                System.out.println("ERROR ERROR");

                System.out.println("Array1");
                for (int i = 0; i < n; i++) {
                    System.out.print(array1[i] + " ");
                }

                System.out.println();

                System.out.println("Array2");
                for (int i = 0; i < n; i++) {
                    System.out.print(array2[i] + " ");
                }

                break;
            }

            System.out.println("####################################");
            System.out.println();
            System.out.println();

            //compare array1 == array2

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

