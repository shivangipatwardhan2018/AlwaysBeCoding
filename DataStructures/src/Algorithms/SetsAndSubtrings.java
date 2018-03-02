package Algorithms;

import java.util.ArrayList;

/**
 * Created by shivangipatwardhan on 3/1/18.
 */
public class SetsAndSubtrings {
//
//    public ArrayList<ArrayList<Integer>> createAllSubsets(int[] input, int index){
//
//
//
//
//    }

    public ArrayList<ArrayList<Integer>> generateAllSubsets(ArrayList<Integer> input){
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();

        int max = 1 << input.size();
        for(int k = 0; k < max; k++){
            allsubsets.add(convertIntToSet(k, input));
        }

        return allsubsets;
    }

    private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> input) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for(int k = x; k > 0; k >>= 1){
            if((k & 1) == 1){
                subset.add(input.get(index));
            }
            index++;
        }
        return subset;
    }
}
