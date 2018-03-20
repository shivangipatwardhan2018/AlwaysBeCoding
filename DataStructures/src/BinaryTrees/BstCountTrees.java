package BinaryTrees;

import java.util.Arrays;

/**
 * Suppose you are building an N node binary search tree with the values 1..N.
 * How many structurally different binary search trees are there that store
 * those values? Write a recursive function that, given the number of distinct
 * values, computes the number of structurally unique binary search trees that
 * store those values.
 *
 * Signature of expected method:
 *
 *    public static <T> long countTrees(int numKeys);
 *
 * For example, countTrees(4) should return 14, since there
 * are 14 structurally unique binary search trees that store 1, 2, 3, and 4.
 */
public class BstCountTrees {


    public static <T> long countTrees(int numKeys){


        if(numKeys == 0 || numKeys == 1){
            return 1L;
        }

        int[] dp = new int[numKeys+1];
        Arrays.fill(dp, 0);

        dp[0] =  1;
        dp[1] = 1;

        for(int i = 2; i <= numKeys; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

      return dp[numKeys];

    }

    public static void main(String[] argv){
        System.out.println(countTrees(15));
    }
}
