package SortingAlgorithms;

//Implementation of Merge Sort


public class MergeSort {


    public void mergesort(int[] elements){
        if(elements == null || elements.length == 0){
            return;
        }

        if(elements.length == 1){
            return;
        }

        int start = 0;
        int end = elements.length -1;

        mergesort(elements, start, end);
    }

    private void mergesort(int[] elements, int start, int end) {

//        if(elements.length == 1){
//            return;
//        }
        if(start < end){
            int middle = (end + start)/2;

            mergesort(elements, start, middle);
            mergesort(elements, middle+1, end);

            merge(elements, start, middle, end);
        }

    }

    private void merge(int[] elements, int start, int middle, int end) {
        int array1 = middle - start + 1;
        int array2 = end - middle;

        int L[] = new int[array1];
        int R[] = new int[array2];

        for(int i = 0; i < array1; i++){
            L[i] = elements[start+i];
        }

        for(int i = 0; i < array2; i++){
            R[i] = elements[middle+1+i];
        }

        // Merge
        int i = 0, j = 0;
        int k = start;
        while(i < array1 && j < array2){

            if(L[i] <= R[j]){
                elements[k] = L[i];
                i++;
            }else if(R[j] < L[i]){
                elements[k] = R[j];
                j++;
            }
            k++;
        }

        //Copy Remaining Over
        while(i < array1){
            elements[k] = L[i];
            i++;
            k++;
        }

        while (j < array2){
            elements[k] = R[j];
            j++;
            k++;
        }

    }


    public static void main (String[] args){
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.mergesort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }

}
