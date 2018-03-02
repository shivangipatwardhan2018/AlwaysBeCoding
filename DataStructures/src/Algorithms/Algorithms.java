package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shivangipatwardhan on 2/28/18.
 */
public class Algorithms {

    private static void fibonacciTests(){
        FibonacciSequences fs = new FibonacciSequences();
        System.out.println(fs.basicFibonacciSequences(1));
        System.out.println(fs.basicFibonacciSequences(14));
        System.out.println(fs.basicFibonacciSequences(16));
        System.out.println(fs.basicFibonacciSequences(19));
        System.out.println(fs.basicFibonacciSequences(20));
        System.out.println(fs.recursionFibonacciSequences(1));
        System.out.println(fs.recursionFibonacciSequences(14));
        System.out.println(fs.recursionFibonacciSequences(16));
        System.out.println(fs.recursionFibonacciSequences(19));
        System.out.println(fs.recursionFibonacciSequences(20));
        System.out.println(fs.dynamicFibonacciSequences(1));
        System.out.println(fs.dynamicFibonacciSequences(14));
        System.out.println(fs.dynamicFibonacciSequences(16));
        System.out.println(fs.dynamicFibonacciSequences(19));
        System.out.println(fs.dynamicFibonacciSequences(20));
    }

    private static void pascalTests(){
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(Arrays.toString(pt.generatePascalsTriangle(8).toArray()));
    }

    public static void main(String[] args){
//        pascalTests();
        WordLadder wl = new WordLadder();
        List<String> newArray = new ArrayList<>();
        newArray.add("hot");
        newArray.add("dot");
        newArray.add("dog");
        newArray.add("lot");
        newArray.add("log");
        newArray.add("cog");
        System.out.println(wl.ladderLength("hit", "cog", newArray));
    }
}
