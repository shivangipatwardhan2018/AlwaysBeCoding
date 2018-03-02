package Algorithms;

/**
 * Created by shivangipatwardhan on 2/28/18.
 */
public class FibonacciSequences {

    //Cache significantly reduces the time requires for computations once the cache is filled enough
    int[] cacheElements = new int[200];
    public int dynamicFibonacciSequences(int input){
        if(input == 0) return 0;
        if(input == 1) return 1;
        if(cacheElements[input] != 0) return cacheElements[input];
        cacheElements[input] = dynamicFibonacciSequences(input - 1) + dynamicFibonacciSequences(input - 2);
        return cacheElements[input];
    }

    //Runtime O(2^n)
    public int recursionFibonacciSequences(int input){
        if (input == 0) return 0;
        if (input == 1) return 1;

        return recursionFibonacciSequences(input - 1) + recursionFibonacciSequences(input - 2);
    }


    public int basicFibonacciSequences(int input){
        if(input == 0) return 0;
        if(input == 1) return 1;

        int elementOne = 0;
        int elementTwo = 1;
        int sum = 0;

        for(int i = 1; i < input; i++){
            sum = elementOne + elementTwo;
            elementOne = elementTwo;
            elementTwo = sum;

        }

        return sum;
    }

}
