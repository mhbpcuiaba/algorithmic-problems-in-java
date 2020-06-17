package br.com.mhbp.arrays_primitives_strings.arrays.dutchflagproblem;

import java.util.Random;

public class TheDutchFlagProblem {

    public static void main(String[] args) {
//        Collections.
        Random r = new Random();

        int numberElements = 17;

        int[] array = new Random().ints(numberElements, 1, 4).toArray();
        // Arrays.parallelSetAll, Arrays.parallelSort()[uses parallel merge sort] => ForkJoinPool
        //more than two cores, otherwise sequential merge sort'

        System.out.println();
        System.out.println("       Current State        ");
        System.out.println();

        int pivotElement = 2;
//        printFlag(array, pivotElement);

//        solveDutchFlagUsingExtraMemory(array, pivotElement);
        solveDutchFlagInPlace(array, pivotElement);


    }

    private static void solveDutchFlagInPlace(int[] array, int pivotElement) {
        int afterPivot = array.length;


        //separa grupo de menores que pivot!!!
        int currentIndex = 0;

        while ( currentIndex < array.length && currentIndex < afterPivot ) {

            if (array[currentIndex] < pivotElement) {
                currentIndex++;
                continue;
            }

            afterPivot--;

            int tmp = array[afterPivot];
            array[afterPivot] = array[currentIndex];
            array[currentIndex] = tmp;
        }

        int beforePivot = 0;

        // fatia start: currentIndex & end: array.length - 1, nessa fatia temos nao temos a garantia da ordenacao elmentos giuais ao pivot e elementos maiores que o pivot estao misturados
        while ( currentIndex < array.length && currentIndex < afterPivot) {

            if (array[afterPivot] > pivotElement) {
                afterPivot--;
                continue;
            }


            int tmp = array[afterPivot];
            array[afterPivot] = array[currentIndex];
            array[currentIndex] = tmp;
            currentIndex++;
        }


    }

      private static void printFlag ( int[] array, int pivotElement){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            for (int j = 0; j < array.length; j++) {
                printFlagline(array[j], pivotElement);
            }
        }

        private static void solveDutchFlagUsingExtraMemory ( int[] array, int pivotElement){

            int[] above = new int[array.length];
            int aIndex = 0;
            int[] middle = new int[array.length];
            int mIndex = 0;
            int[] below = new int[array.length];
            int bIndex = 0;

            for (int i = 0; i < array.length; i++) {

                if (array[i] < pivotElement) {
                    above[aIndex++] = array[i];
                } else if (array[i] == pivotElement) {
                    middle[mIndex++] = array[i];
                } else {
                    below[bIndex++] = array[i];
                }
            }

            int index = 0;
            for (int i = 0; i < aIndex; i++) {
                array[index++] = above[i];
            }
            printFlag(array, pivotElement);
            for (int i = 0; i < mIndex; i++) {
                array[index++] = middle[i];
            }
            printFlag(array, pivotElement);
            for (int i = 0; i < bIndex; i++) {
                array[index++] = below[i];
            }
            printFlag(array, pivotElement);

        }

        private static void printFlagline ( int element, int pivotElement){

            if (element == pivotElement) {
                printWhite();
            } else if (element > pivotElement) {
                printRed();
            } else {
                printBlue();
            }
        }


        public static void printRed () {
            printline(Color.RED);
        }

        public static void printWhite () {
            printline(Color.WHITE);
        }

        public static void printBlue () {
            printline(Color.BLUE);
        }

        public static void printline (Color color){
            System.out.println((char) 27 + "[" + color.getValue() + "m" + "===================================================================================");
        }

    }




