package Algorithms;

import java.util.HashSet;
import java.util.List;

/**
 * Created by shivangipatwardhan on 3/1/18.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //["hot","dot","dog","lot","log","cog"]

        HashSet<String> wordsReached = new HashSet<>();
        wordsReached.add(beginWord);

        int distance = 1;

        while(!wordsReached.contains(endWord)){
            //generate all possible words
            HashSet<String> wordsToAdd = new HashSet<>();

            for(String element: wordsReached){

                for(int index = 0; index < element.length(); index++){
                    char[] newWord = element.toCharArray();
                    for(char i = 'a'; i <= 'z'; i++){
                        newWord[index] = i;
                        String word = new String(newWord);
                        if(wordList.contains(word)){
                            wordsToAdd.add(word);
                            wordList.remove(word);
                        }
                    }

                }
            }
            distance++;
            if(wordsToAdd.size() == 0) return 0;
            wordsReached = wordsToAdd;
        }
        return distance;
    }
}
