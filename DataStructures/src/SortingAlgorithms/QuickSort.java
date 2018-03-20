package SortingAlgorithms;

import java.util.Random;

public class QuickSort {

// Pick a pivot value


    public void quicksort(int[] input){

        if(input == null || input.length == 0) {
            return;
        }

        quicksort(input, 0, input.length-1);

    }

    private void quicksort(int[] input, int start, int end) {

        if(start < end){

            int middle = partitionValue(input, start, end);

            quicksort(input, start, middle-1);
            quicksort(input, middle + 1, end);
        }
    }

    private int partitionValue(int[] input, int start, int end) {

        Random rand = new Random();
        int pickPivot = rand.nextInt((end+1)-start) + start;
        int pivot= input[pickPivot];

        int i = start - 1;

        for(int h = start; h < end; h++){
            if(input[h] <= pivot){
                i++;
                int temp = input[i];
                input[i] = input[h];
                input[h] = temp;
            }
        }
        int temp = input[i+1];
        input[i+1] = input[end];
        input[end] = temp;
        return (i + 1);
    }

    public static void main (String[] args){
        int arr[] = {12, 11, 13, 5, -6, 7};

        System.out.println("Given Array");
        printArray(arr);

        QuickSort ob = new QuickSort();
        ob.quicksort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }

}
