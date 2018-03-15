package Arrays;


public class CountInversions {
    /**
     * Count number of inversions in an array of integers.
     *
     * An inversion is a pair of indices: (i,j) such that i < j and array[i] >
     * array[j].
     *
     * Signature of expected method:
     *
     *    public static long countInversions(int[] array)  {...}
     */

    //Use recursion to count inversions

    //Divide and Conquer based on the input array

    private static long mergeAndCountInversions(int[] left, int[] right, int[] merged) {
        //Similar to MergeSort
        int[] tempLeft = new int[left.length];
        int[] tempRight = new int[right.length];

        for(int i = 0; i < tempLeft.length; i++){
            tempLeft[i] = left[i];
        }
        for(int i = 0; i < tempRight.length; i++){
            tempRight[i] = right[i];
        }

        long numInversions = 0L;
        int currentIndex = 0;
        int currentIndexLeft = 0;
        int currentIndexRight = 0;
        while(currentIndexLeft < tempLeft.length && currentIndexRight < tempRight.length){
            if(tempLeft[currentIndexLeft] <= tempRight[currentIndexRight]){
                merged[currentIndex] = tempLeft[currentIndexRight];
                currentIndexLeft++;
            }

            if(tempLeft[currentIndexLeft] > tempRight[currentIndexRight]){
                numInversions += tempLeft.length - currentIndexLeft;
                merged[currentIndex] = tempRight[currentIndexRight];
                currentIndexRight++;
            }
            currentIndex++;
        }

        //Copy the elemtns back
        while(currentIndexLeft < tempLeft.length){
            merged[currentIndex] = tempLeft[currentIndexLeft];
            currentIndexLeft++;
            currentIndex++;
        }
        while(currentIndexRight < tempRight.length){
            merged[currentIndex] = tempRight[currentIndexRight];
            currentIndexRight++;
            currentIndex++;
        }

        while (currentIndexLeft < tempLeft.length) {
            merged[currentIndex] = tempLeft[currentIndexLeft];
            currentIndexLeft++;
            currentIndex++;
        }

        while (currentIndexRight < tempRight.length) {
            merged[currentIndex] = tempRight[currentIndexRight];
            currentIndexRight++;
            currentIndex++;
        }

        return numInversions;
    }

    private static long countInversionsRecursion(int[] array, int start, int end, int[] merged) {
        //Base Cases
         if(start == end){
             return 0L;
         }
        int middle = (end - start)/2;

        int[] left = new int[middle - start + 1];
        long leftInversions = countInversionsRecursion(array, start, middle, left);
        int[] right = new int[end - middle];
        long rightInversions = countInversionsRecursion(array, middle + 1, end, right);

        return leftInversions + rightInversions
                + mergeAndCountInversions(left, right, merged);

    }

    private static long countInversionsRecursion(int[] array) throws Exception {
        if(array == null){
            throw new Exception("Illegal Input Format");
        }

        return countInversionsRecursion(array, 0, array.length-1, new int[array.length]);
    }


    // Runtime: O(n^2)
    public static long countInversionsBruteForce(int[] array)  {
        int inversions = 0;

        if(array == null){
            return -1;
        }

        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length ; j++){
                if(array[i] > array[j]){
                    inversions++;
                }
            }
        }
        return inversions;
    }



    public static void main(String[] args) throws Exception {
        int[] array = new int[]{2, 1, 3, 7, 5, 9};
        long value = countInversionsBruteForce(array);
        System.out.println(value);

        long soln = countInversionsRecursion(array);
        System.out.println(soln);


    }

}


