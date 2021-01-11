package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO Revisar
public class TripletWithSmallerSum {

    public static void main(String[] args) {
        int[] arr1 = { -1, 0, 2, 3 };
        searchTripletsSumCloseTarget(arr1, 3);
        System.out.println(result);
        //result.forEach(l -> System.out.println(l));
      //  int[] arr2 = { -1, 4, 2, 1, 3 };
    }


    static List<List<Integer>> result = new ArrayList<>();

    public static void searchTripletsSumCloseTarget(int[] arr, int target) {


        Arrays.sort(arr);


        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1, right = arr.length - 1;

            while (left < right) {
                int diff = arr[i] + arr[left] + arr[right] - target;


                if (diff < 0) {
                    System.out.println("indexes: " + i + ", " +  left + ", " + right);
                    int tmpRignt = right;
                    result.add(Arrays.asList(arr[i], arr[left], arr[tmpRignt--]));
                    while (left < tmpRignt ) {
                        if (arr[tmpRignt] < arr[tmpRignt + 1])
                            result.add(Arrays.asList(arr[i], arr[left], arr[tmpRignt]));
                        tmpRignt--;
                    }
                    left++;
                } else {
                    right--;
                }


            }
        }

    }


}
