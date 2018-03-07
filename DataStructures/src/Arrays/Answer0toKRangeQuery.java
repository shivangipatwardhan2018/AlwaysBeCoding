package Arrays;

import java.util.Arrays;

/**
 * Write a class that given an array of N integers with values in the range 0 to
 * K, pre-processes its input and then answers any query about how many of the N
 * integers fall into a range [A,B] in O(1) time (note: the range includes A and
 * B). Your algorithm can use no more than O(N + K) pre-preocessing time.
 *
 * Your class: Answer0toKRangeQuery should implement a constructor with the
 * following signature. The constructor should take as input the array to be
 * processed, and the value K which determines the range 0 to K.
 *
 *    Answer0toKRangeQuery(int[] array, int k)  {...}
 *
 * Your class should also implement the method:
 *
 *    int countNumIntegers(int rangeStart, int rangeEnd)  {...}
 *
 * The above method answers the required queries in O(1) time.
 */

public class Answer0toKRangeQuery {

    private final int[] counters;
    private final int k;

    public Answer0toKRangeQuery(int[] array, int kInput){
        if(kInput < 0){
            throw new IllegalArgumentException("Range cannot be less than 0");
        }

        counters = new int[kInput+1];
        Arrays.fill(counters, 0);
        k = kInput;

        for(int i = 0; i < array.length; i++){
            counters[array[i]] = 1;
        }

        int tally = 0;
        for(int i = 0; i < kInput + 1; i++){
            if(counters[i] != 0){
                tally += counters[i];
                counters[i] = tally;
            }
        }
    }

    public int countNumIntegers(int rangeStart, int rangeEnd){
        if(rangeStart < 0){
            throw new IllegalArgumentException("Start cannot be less than 0");
        }

        if(rangeEnd > k ){
            throw new IllegalArgumentException("End cannot be greater than given k");
        }

        return counters[rangeEnd] - counters[rangeStart];

    }

    public static void main(String[] args){
        int[] array = new int[]{7, 10, 8, 4, 1};
        Answer0toKRangeQuery ar = new Answer0toKRangeQuery(array, 10);
        int val = ar.countNumIntegers(1, 8);
        System.out.println(val);
        int val2 = ar.countNumIntegers(0, 10);
        System.out.println(val2);
        int val3 = ar.countNumIntegers(2, 3);
        System.out.println(val3);

    }

}
