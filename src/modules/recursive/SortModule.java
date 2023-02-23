package modules.recursive;

public class SortModule {

    private static int[] getFirstHalf(int[] data) {
        //TODO : update to get first half of array

        int mid = data.length/2;
        int left[] = new int[mid];

        for (int i = 0; i < mid; i++){
            left[i] = data[i];
        }
        return left;
    }


    private static int[] getSecondHalf(int[] data) {
        //TODO : update to get second half of array

        int mid = data.length/2;
        int right[] = new int[data.length - mid];

        for (int i = 0; i < data.length - mid; i++){
            right[i] = data[mid+i];
        }

        return right;

    }


    private static void merge(int[] data, int[] left, int[] right) {
        //TODO : update to merge arrays

        int index = 0;
        int LeftIndex = 0;
        int RightIndex = 0;

        while (LeftIndex < left.length && RightIndex < right.length){
            if (left[LeftIndex] < right[RightIndex]){
                data[index++] = left[LeftIndex++];
            }
            else {
                data[index++] = right[RightIndex++];
            }
        }
        while (LeftIndex < left.length){
            data[index++] = left[LeftIndex++];
        }
        while (RightIndex < right.length){
            data[index++] = right[RightIndex++];
        }

    }


    public static void mergeSort(int[] data) {
        //TODO : update with algorithm

        if (data.length > 1){
            int [] left = getFirstHalf(data);
            int [] right = getSecondHalf(data);

            mergeSort(left);
            mergeSort(right);

            merge(data, left, right);
        }

    }


    private static int partition(int[] data, int low, int high) {
        //TODO: update with partition algorithm

        int midpoint = (low + high)/2;
        int pivot = data[midpoint];

        boolean check = false;
        while (check == false){
            while (data[low] < pivot){
                low++;
            }
            while (pivot < data[high]){
                high--;
            }

            if (low >= high){
                check = true;
            }
            else {
                swap(data, low, high);
                ++low;
                --high;
            }
        }

        return high;
    }


    public static void quickSort(int[] data) {
        //TODO : update to call helper method

        quickSort(data, 0, data.length -1);
    }


    private static void quickSort(int[] data, int min, int max) {
        //TODO: update to partition list

        int mid;

        if (min < max) {

            mid = partition(data, min, max);
            quickSort(data, min, mid);
            quickSort(data, mid + 1, max);

        }
    }


    public static void selectionSort(int[] data) {
        selectionSort(data,0);
    }


    private static void selectionSort(int[] data, int start) {
        int minIndex;

        if(start < data.length - 1){
            minIndex = start;
            for (int i = start + 1; i < data.length; i++)
                if(data[i] < data[minIndex])
                    minIndex = i;

            swap(data, start, minIndex);
            selectionSort(data, start + 1);
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a]  = data[b];
        data[b]  = temp;
    }
}
