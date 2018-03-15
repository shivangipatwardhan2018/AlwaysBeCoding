package Arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * You are given an array of size N containing *only* non-negative integers
 * (i.e. >= 0). From any index in the array, a hop can be either of the
 * following:
 *
 * [1] Jump array[index] positions
 * [2] Jump 1 position
 *
 * The target of this question is to find the number of hops required to reach
 * the last element in the array from the first element.
 *
 * Signature of expected method:
 *
 *    public static int findNumHops(int[] array)  {...}
 */

public class FindNHops {
    //int[] input = {0, 5, 10, 1, 4, 7, 2, 1, 1};

    public static int findNumHopsFancy(int[] array) {
        if (array == null) {
            throw new NullPointerException("array can't be null.");
        }

        if (array.length == 0) {
            return 0;
        }

        Set<Integer> steps = new HashSet<Integer>();
        int lastSeenStep = array.length - 1;
        steps.add(lastSeenStep);

        for (int index = array.length - 2; index >= 0; index--) {
            int hopSize = array[index];
            int reachableStep = hopSize + index;

            if (steps.contains(reachableStep)) {
                for (Iterator<Integer> iter = steps.iterator(); iter.hasNext();) {
                    int step = iter.next();
                    if (step < reachableStep) {
                        iter.remove();
                    }
                }

                steps.add(index);
                lastSeenStep = index;
            }
        }

        return steps.size() - 1 + lastSeenStep;
    }

    public static int findNumHops(int[] array)  {

        if(array == null){
            return -1;
        }

        if(array.length == 0){
            return 0;
        }

        int numHops = 0;
        int location = 0;
        int remainingDistance = array.length - 1;

        while(remainingDistance != 0){
            int possibleHop = array[location];
            if(possibleHop > 1 && possibleHop < remainingDistance){
                location += array[location];
                remainingDistance = remainingDistance - location;
            }else{
                location++;
                remainingDistance--;
            }
            numHops = numHops + 1;
        }

        return numHops;

    }

    //[0, 5, 10, 1, 4, 7, 2, 1, 1]
    public static void main(String[] args){
        int[] input = {0, 5, 10, 1, 4, 7, 2, 1, 1};

        System.out.println(findNumHops(input));
        System.out.println(findNumHopsFancy(input));
    }

}
