package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find common elements between two sorted integer arrays.
 *
 * Signature of expected method:
 *
 *    public static List<Integer> findCommonElements(int[] a, int[] b)  {...}
 */

public class FindCommonElements {

    public static List<Integer> findCommonElements(int[] a, int[] b) {
        if(a == null || b == null){
            return null;
        }

        List<Integer> soln = new ArrayList<>();

        for(int aIndex = 0, bIndex = 0; aIndex < a.length && bIndex < b.length;){
            if(a[aIndex] < b[bIndex]){
                aIndex++;
            }
            if(a[aIndex] > b[bIndex]){
                bIndex++;
            }else{
                soln.add(a[aIndex]);
                aIndex++;
                bIndex++;
            }
        }

        return soln;
    }
}
