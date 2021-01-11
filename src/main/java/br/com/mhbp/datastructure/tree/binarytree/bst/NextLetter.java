package br.com.mhbp.datastructure.tree.binarytree.bst;



public class NextLetter {

    char searchNextLetter(char[] letters, char key) {

        int start = 0, end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (letters[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //since the loop is running until start <= end, so at th end of the while loop
        return letters[start % letters.length];
    }
}

