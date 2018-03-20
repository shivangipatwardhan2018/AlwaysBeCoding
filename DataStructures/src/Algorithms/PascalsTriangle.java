package Algorithms;

import java.util.ArrayList;

public class PascalsTriangle {

    public ArrayList<ArrayList<Integer>> generatePascalsTriangle(int rowNum){
        ArrayList<ArrayList<Integer>> finalSoln = new ArrayList<>();
        ArrayList<Integer> nextRow = new ArrayList<>();

        for(int i = 0; i < rowNum; i++){
            nextRow.add(0,1);
            for(int j = 1; j < nextRow.size()-1; j++){
                nextRow.set(j, nextRow.get(j) + nextRow.get(j+1));
            }
            finalSoln.add(new ArrayList<>(nextRow));
        }

        return finalSoln;
    }



    public ArrayList<Integer> generateNthRowOfPascalsTriangle(int rowNum){

        ArrayList<Integer> soln = new ArrayList<>();

        for(int i = 0; i < rowNum; i++){
            soln.add(1);
            for(int j = i-1; j > 0; --j){
                soln.set(j, soln.get(j-1) + soln.get(j));
            }
        }

        return soln;
    }
}
