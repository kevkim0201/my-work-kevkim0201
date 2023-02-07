package modules.iterative;

/****************************************************************
 * This module implements modules iterative algorithms for array
 * data structures with integer precision.
 ****************************************************************/

public class SortModule {

    //TODO: Update/Complete the following bubbleSort algorithm
    //      using for loops and swap method (see below)
    public static void bubbleSort(int[] data) {
        //TODO: Complete Body


        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j] < data[j-1]){
                    swap(data, j, j-1);
                }
            }
        }
    }

    //TODO: Update/Complete the following insertionSort algorithm
    //      using for loops
    public static void insertionSort(int[] data) {
        //TODO: Complete Body

        int a;
        int currentValue;

        for (int i = 1; i < data.length; i++) {
            currentValue = data[i];
            for (a = i; a > 0 && currentValue < data[a - 1]; a--) {
                data[a] = data[a - 1];
            }
            data[a] = currentValue;
        }
    }


    // This is an example of "finding the run time function"
    // for a maximum value algorithm

    /* public static int max(int[] data) {
        int n = data.length;          // (1)      data size
        int max = data[0];              // (1)

        //       (1)
        for (int i = 0; i < n; i++) {   // n times
            // (1  + 1)
            if (max < data[i])               // (1)
                max = data[i];              // (1)
            // (1)      terminates loop
        }// (1)
        return max;

     */

    // run time function f(n) = 1 + 1 + 1 + n(2 + 1 + 1)
    //                   f(n) = 4n + 5


    //TODO: Update/Complete the following selectionSort algorithm
    //      using for loops and swap method (see below)
    public static void selectionSort(int[] data) {
        //TODO: Complete Body

        int minimum;
        int j;
        int k;

        for (j = 0; j < data.length; j++) {
            minimum = j;
            for (k = j + 1; k < data.length; k++) {
                if (data[k] < data[minimum]) {
                    minimum = k;
                }
            }

            if (minimum != j) {      /* swapping code */
                swap(data, minimum, j);
            }
        }

    }

    //TODO: Update/Complete the following swap method
    public static void swap(int[] data, int i, int j) {

        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;

    }

}
