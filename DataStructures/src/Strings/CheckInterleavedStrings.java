package Strings;

/**
 * We are given 3 strings: str1, str2, and str3. Str3 is said to be a shuffle of
 * str1 and str2 if it can be formed by interleaving the characters of str1 and
 * str2 in a way that maintains the left to right ordering of the characters
 * from each string. For example, given str1=ÓabcÓ and str2=ÓdefÓ, str3=ÓdabecfÓ
 * is a valid shuffle since it preserves the character ordering of the two
 * strings. So, given these 3 strings write a function that detects whether str3
 * is a valid shuffle of str1 and str2.
 *
 * http://www.ardendertat.com/2011/10/10/programming-interview-questions-6-
 * combine-two-strings/
 */

public class CheckInterleavedStrings {

    public static boolean isShuffledStrings(String a, String b, String c){

        if (a == null || b == null || c == null) {
            return false;
        }

        if (c.length() != a.length() + b.length()) {
            return false;
        }

        char[] elements = c.toCharArray();

        int j = 0, k = 0, i = 0;
        while (i < c.length() ){
            char curChar = elements[i];

            if(j < a.length() && curChar == a.charAt(j)){
                j++;
            }else if(k < b.length() && curChar == b.charAt(k)){
                k++;
            }else{
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main (String[] args){
        String str1 = "abc";
        String str2 = "dhef";
        String str3 = "dabecf";
        CheckInterleavedStrings check = new CheckInterleavedStrings();
        System.out.println(check.isShuffledStrings(str1, str2, str3));
    }

}
