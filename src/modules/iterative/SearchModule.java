package modules.iterative;

/****************************************************************
 * This module implements modules iterative algorithms for array
 * data structures with integer precision.
 ****************************************************************/

public class SearchModule {

    //TODO: Complete this search algorithm to find an element location is in array
    //      use while loops here
    public static int binarySearch(int[] data, int target) {
        //TODO: update with search algorithm

        int min = 0;
        int max = data.length - 1;
        int mid;

        while (min <= max) {
            mid = (min + max) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }


    //TODO: Complete this search algorithm to check if an element is in array
    public static boolean contains(int[] data, int target) {

        for (int number : data) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }


    //TODO: Complete this search algorithm to find an element location is in array
    //      use for loops here
    public static int indexOf(int[] data, int target) {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args){

        int answer;
        int[] array = {60, 41, 92, 32, 12, 52, 21};
        answer = binarySearch(array,41);

        System.out.println(answer);
    }
}
