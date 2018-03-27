package Strings;


import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    public static void main(String[] args){
        String str = "ABC";
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        AllPermutations permutations = new AllPermutations();
//        permutations.permuteStrings("" , str);
        permutations.permuteList(new ArrayList<>() , input);
        System.out.println(input);
    }


    private void permuteList(List<Integer> prefix, List<Integer> rest){
        int n = rest.size();

        if(n == 0){
            System.out.println(prefix);
        }else{
            for(int i = 1; i < n; i++){
                prefix.add(rest.get(i));

                List<Integer> input = rest.subList(0, i);
                List<Integer> secondHalf = rest.subList(i+1, n);
                input.addAll(secondHalf);

                permuteList(prefix, input);
            }

        }

    }


    private void permuteStrings(String prefix, String str){
        int n  = str.length();
        if(n == 0){
            System.out.println(prefix);
        }else{
            for(int i = 0; i < n; i++){
                permuteStrings(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1,n));
            }
        }
    }

    private String swap(String a, int l, int i) {
        char temp;
        char[] charArray = a.toCharArray();

        temp = charArray[i];
        charArray[i] = charArray[l];
        charArray[l] = temp;
        return String.valueOf(charArray);
    }

}
