package br.com.mhbp.arrays_primitives_strings.arrays;

import java.util.Arrays;

public class PizzaLove {

    public static void main(String[] args) {

        int[] arr = { 4, 5, 1};
//        System.out.println(3/2);
//        System.out.println(4/2);
//        System.out.println(5/2);
//        System.out.println(10/2);
//        System.out.println(11/2);
        System.out.println(maxPizza(3, arr));
    }

    //TODO preciso entender!!!!!
    static  int maxPizza(int n , int[] arr)    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;

        for (int i = 1; i < n; i++)    {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            int current = arr[i];
            incl = excl + current;
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
}
