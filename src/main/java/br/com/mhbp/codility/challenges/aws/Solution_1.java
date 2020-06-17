package br.com.mhbp.codility.challenges.aws;

public class Solution_1 {

    public static void main(String[] args) {
        int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};

//        System.out.println(new Solution_1().solution(A));
        System.out.println(new Solution_1().maxTurbulenceSize(A));
        System.out.println(new Solution_1().maxTurbulenceSize(A));
        System.out.println(new Solution_1().maxTurbulenceSize(A));
    }

    public int maxTurbulenceSize(int[] A) {

        boolean nextIsExpectedToBeBigger = true;
        int presentTurbulence = 1;
        int maxTurbulence = 0;

        for (int index = 1;  index < A.length; index++) {

            if (presentTurbulence == 1 && !(A[index] == A[index -1])) {
                presentTurbulence++;
                nextIsExpectedToBeBigger = (A[index - 1] < A[index]);

            } else {

                if (!nextIsExpectedToBeBigger && (A[index - 1] < A[index])){
                    presentTurbulence++;
                    nextIsExpectedToBeBigger = !nextIsExpectedToBeBigger;

                } else if (nextIsExpectedToBeBigger && (A[index - 1] > A[index])) {
                    presentTurbulence++;
                    nextIsExpectedToBeBigger = !nextIsExpectedToBeBigger;

                } else if (A[index - 1] == A[index]) {
                    maxTurbulence = Math.max(maxTurbulence, presentTurbulence);
                    presentTurbulence = 1;
                    nextIsExpectedToBeBigger = true;

                } else {
                    maxTurbulence = Math.max(maxTurbulence, presentTurbulence);
                    presentTurbulence = 2;
                    nextIsExpectedToBeBigger = (A[index - 1] < A[index]);

                }
            }
        }

        return Math.max(maxTurbulence, presentTurbulence);
    }

/*


Example test:    (1, (2, (3, (2, None, None), None), (6, None, None)), (3, (3, None, None), (1, (5, None, None), (6, None, None))))
OK

Example test:    (1, (2, (1, None, None), (2, None, None)), (2, (4, None, None), (1, None, None)))
OK

Example test:    (1, None, (2, (1, None, None), (1, (4, None, None), None)))
WRONG ANSWER  (got 3 expected 2)

Your test case:  (1, (2, (3, (2, None, None), None), (6, None, None)), (3, (3, None, None), (1, (5, None, None), (6, None, None))))
Returned value: 3

https://www.geeksforgeeks.org/root-leaf-path-maximum-distinct-nodes/
 */


    public int solution(int[] A) {
        int result = 1;
        int[] tmp = new int[A.length];

        if (A.length > 1) {

            System.out.println("start loop");
            int i = 0;
            int j = i + 1;
            int count = 1;

            int initialIndex = 0;

            while( j < A.length - 1 ) {

                System.out.println("i: " + i);
                System.out.println("j: " + j);


                boolean nextIsExpectedToBeBigger = (A[i] < A[j]);

                if (nextIsExpectedToBeBigger) {

                    if (A[i] < A[i + 1]) {
                        count++;
                        nextIsExpectedToBeBigger = !nextIsExpectedToBeBigger;
                    } else {
                        initialIndex = i;
                        i = j;
                        break;
                    }

                } else {

                    if (A[i] > A[i + 1]) {
                        count++;
                        nextIsExpectedToBeBigger = !nextIsExpectedToBeBigger;
                    } else {
                        initialIndex = i;
                        i = j;
                        break;
                    }

                }
                    i++;
                    j++;


                tmp[i] = count;
                if (result < count) {
                    result = count;
                }
            }

            System.out.println("end loop");
        }

        return result;
    }
}
