package Graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a static list of english words. You are supposed to build a
 * data structure from the list of words which is both space efficient, and can
 * also efficiently answer query to check if a particular word exists in the
 * list of words. Note that the searched word can contain the letter '?' in
 * addition to regular characters. The character '?' is a wild card and
 * represents the occurrence of any random letter exactly once.
 *
 * Examples:
 * ---------
 *
 * Input: ["dog", "cat", "bat", "seat"]
 *
 * Queries:
 *
 * 1. exists("do?") => true (matches dog)
 * 2. exists("???") => true (matches dog, cat, bat)
 * 3. exists ("??a?") => true (matches seat)
 * 4. exists("ca??") => false
 * 5. exists("bats") => false
 */

class GraphNode{
    Set<GraphNode> nodes;
    Character character;
    boolean last;

    GraphNode(char ch) {
        nodes = new HashSet<GraphNode>();
        character = ch;
        last = false;
    }

}

public class WordChecker {

    private final Set<GraphNode> nodes;

    public WordChecker(List<String> words) {

        if (words == null) {
            throw new IllegalArgumentException("List of words can't be null.");
        }

        nodes = new HashSet<GraphNode>();

        for (String word : words) {
            if (word != null && word.length() > 0) {
                addWordToGraph(word.toCharArray(), 0, null, nodes);
            }
        }
    }

    private void addWordToGraph(char[] word, int index, GraphNode currentNode, Set<GraphNode> nodes) {
        if(index >= word.length){
            currentNode.last = true;
            return;
        }

        char ch = word[index];
        for(GraphNode node: nodes){
            if(node.character == ch){
                addWordToGraph(word, index + 1, node, node.nodes);
                return;
            }
        }

        GraphNode node = new GraphNode(word[index]);
        nodes.add(node);

        addWordToGraph(word, index + 1, node, node.nodes);

    }

    public boolean exists(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        return check(word.toCharArray(), 0, null, nodes);
    }

    private boolean check(char[] word, int index, GraphNode currentNode, Set<GraphNode> nodes) {

        if (index >= word.length) {
            if (currentNode.last) {
                return true;
            }

            return false;
        }

        if (word[index] == '?') {
            for (GraphNode node : nodes) {
                if (check(word, index + 1, node, node.nodes)) {
                    return true;
                }
            }
        } else {
            for (GraphNode node : nodes) {
                if (node.character == word[index]) {
                    return check(word, index + 1, node, node.nodes);
                }
            }
        }

        return false;
    }


}
