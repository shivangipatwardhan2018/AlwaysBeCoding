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



    public static void main(String[] args){
        int[] array = new int[]{2, 1, 3, 7, 5, 9};
        long value = countInversionsBruteForce(array);
        System.out.println(value);


    }

}


