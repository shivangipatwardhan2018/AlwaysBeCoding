package SortingAlgorithms;


public class HeapSort {

    private void heapsort(int[] arr) {

        int numElements = arr.length;

        //{12, 11, 13, 5, 6, 7}
        for(int i = numElements/2 - 1; i >= 0; i--){
            heapify(arr, numElements, i);
        }

        for(int i = numElements - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }

    }

    private void heapify(int[] array, int numElements, int rootIndex){

        int largest = rootIndex;
        int left = 2*largest + 1;
        int right = 2*largest + 2;

        if(left < numElements && array[left] > array[rootIndex]){
            largest = left;
        }

        if(right < numElements && array[right] > array[largest]){
            largest = right;
        }

        if(largest != rootIndex) {

            //Swap
            int swap = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, numElements, largest);
        }
    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.heapsort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }


}
