package DataStructures;

import java.util.Stack;

/**
 * Created by shivangipatwardhan on 2/20/18.
 */
public class ReverseWords {

    public String reverseWords(String s) {

        if("".equals(s)){
            return "";
        }

        Stack<String> soln = new Stack<>();
        String word = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                soln.add(" ");
                soln.push(word);
                word = "";
            }
            word = word + s.charAt(i) ;

        }

        String solnStr = "";

        while(!soln.empty()){
            solnStr = solnStr + soln.pop();
        }

//        System.out.println(solnStr);
        return solnStr;
    }


}
