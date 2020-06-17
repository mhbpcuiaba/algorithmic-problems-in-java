package br.com.mhbp.amazon;

import java.util.*;

import static java.util.Arrays.asList;

public class AmazonGoStore {


    public static void main(String[] args) {
        List<List<Integer>> grid = asList(
                asList(1, 1, 0, 0),
                asList(0, 0, 1, 0),
                asList(0, 0, 0, 0),
                asList(1, 0, 1, 1),
                asList(1, 1, 1, 1)
                );

        System.out.println(numberAmazonGoStore(5, 4, grid));
    }






    public static List<Integer> lengthEachScene(List<Character> inputList) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < inputList.size(); i++) {
            map.put(inputList.get(i), i);

        }

        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;

        for (int k = 0; k < inputList.size(); k++) {

            right = Math.max(right, map.get(inputList.get(k)));

            if (right == k) {
                result.add(1 + right + left);
                left = right + 1;
            }

            
        }

        return result;
    }







    static class Pair {
        int row, col;
    }
    public static int numberAmazonGoStore(int rows, int columns, List<List<Integer>> grid) {
        int cColors = 0;
        List<Integer> groups = new ArrayList<>(Collections.nCopies(rows * columns, 0 ));

        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {

                if (grid.get(i).get(k) == 1) { // there is a building in the current position

                    int currentIndex = (i * columns) + k;
                    if ( i - 1 >= 0 && grid.get(i - 1).get(k) == 1 && k - 1 >= 0 && grid.get(i).get(k - 1) == 1  ) { // there is building up and left?
                        int groupsTop =  groups.get((i - 1 * columns) + k);
                        int groupsLeft = groups.get((i  * columns) + k - 1);


                        groups.set(currentIndex, groupsTop);
                        if (groupsLeft != groupsTop) {
                            for (int p = 0; p < groups.size(); p++) {
                                if (groups.get(p) == groupsLeft) {
                                    groups.set(p, groupsTop);
                                }
                            }
                            cColors--;

                        }

                        //check which is group has the smaller currentIndex and then join the groups plus element
                    } else if ( i - 1 >= 0 && grid.get(i - 1).get(k) == 1) {  // there is building  up
                        int groupsTop =  groups.get((i - 1 * columns) + k);
                        groups.set(currentIndex, groupsTop);
                    } else if ( k - 1 >= 0 && grid.get(i).get(k - 1) == 1  ) { //there is building left
                        int groupsLeft = groups.get((i  * columns) + k - 1);
                        groups.set(currentIndex, groupsLeft);

                    } else { // it is a building alone
                        /*
                        (i * columns) + k  = 0

                        0  * cols + 0 + 1  => 1
                        1 + 0 + 1  => 2
                        0 + 1 + 1  => 2
                         */


                        groups.set(currentIndex, ++cColors);
                    }

                }

            }
        }


        return cColors;
    }
}
