package Arrays;

//Given an array of integers, a, return the maximum difference
// of any pair of numbers such that the larger integer in the pair
// occurs at a higher index (in the array) than the smaller integer
// type of question


public class MaxDifference {

    public int maxDifference(int[] array){
        int maxDiff = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            int localDiff = Integer.MIN_VALUE;
            for(int j = i+1; j < array.length; j++){
                if(array[j] > array[i]){
                    localDiff = array[j] - array[i];
                    if(maxDiff < localDiff){
                        maxDiff = localDiff;
                    }
                }
            }
        }
        return maxDiff;
    }


    public static void main(String[] args){
        int[] inout = {8, 4, 3, 7, 199};
        MaxDifference md = new MaxDifference();
        System.out.println(md.maxDifference(inout));
    }

}
