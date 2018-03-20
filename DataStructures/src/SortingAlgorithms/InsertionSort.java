package SortingAlgorithms;

public class InsertionSort {

// O(N^2) Runtime Complexity

    private void insertionSort(int[] arr) {
        for(int i = 2; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

    }

    public static void main (String[] args){
        int arr[] = {12, 11, 13, 5, -6, 7};

        System.out.println("Given Array");
        printArray(arr);

        InsertionSort ob = new InsertionSort();
        ob.insertionSort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }


}
