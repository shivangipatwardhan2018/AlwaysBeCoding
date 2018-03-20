package SortingAlgorithms;


import DataStructures.MinHeap;

import java.util.ArrayList;

public class KthLargestElementInUnsortedArray {

//    public static int findKthLargestElementByMinHeap(int[] array, int index){
//
//    }

    public static int kthElementMinHeap(ArrayList<Integer> input, int index){
        MinHeap mh = new MinHeap(input);
        int soln = 0;
        for(int i = 0; i < index; i++){
            soln = mh.extractMin();
        }
        return soln;
    }

    public static int findKthLargestElementBySorting(int[] array, int index){

        mergesort(array, 0, array.length-1);
        return array[index - 1];

    }

    private static void mergesort(int[] array, int start, int end) {

        if(start < end){
            int middle = (end + start)/2;

            mergesort(array, start, middle);
            mergesort(array, middle+1, end);

            sort(array, start, middle, end);
        }

    }

    private static void sort(int[] array, int start, int middle, int end) {

        int left = middle - start + 1;
        int right =  end - middle;

        int[] leftArray = new int[left];
        int[] rightArray = new int[right];

        //Copy over the values
        for(int i = 0; i < left; i++){
            leftArray[i] = array[start+i];
        }

        for(int j = 0; j < right; j++){
            rightArray[j] = array[middle+j+1];
        }

        // Merge
        int i = 0, j = 0;
        int k = start;
        while(i < left && j < right){

            if(leftArray[i] <= rightArray[j]){
                array[k] = leftArray[i];
                i++;
            }else if(rightArray[j] < leftArray[i]){
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }


        //Copy over remaining elements
        while(i < left){
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < right){
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }


    public static void main(String[] args)
    {
        int[] arr = new int[]{12, 3, 5, 7, 19};
        int k = 2;
        System.out.println( "K'th smallest element is "+
                findKthLargestElementBySorting(arr, k) );

        int arr2[] = {12, 3, 5, 7, 19};
        ArrayList<Integer> input = new ArrayList<>();
        for(int i = 0; i < arr2.length; i++){
            input.add(arr2[i]);
        }
        System.out.println("K'th smallest element is " + kthElementMinHeap(input, 4));

    }

}
