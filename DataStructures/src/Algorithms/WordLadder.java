package Algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    For example,

    Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

*/

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> reached = new HashSet<>();
        reached.add(beginWord);

        int distance = 0;
        while(!reached.contains(endWord)){
            Set<String> toAdd = new HashSet<String>();
            for(String word: reached) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordArray[i] = ch;
                        String wordString = wordArray.toString();

                        if (wordList.contains(wordString)) {
                            toAdd.add(wordString);
                            wordList.remove(wordString);
                        }
                    }
                }

            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }

        return distance;

    }
}
