package BinaryTrees;


import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a BST, find the mode i.e. the value that occurs maximum number of
 * times.
 *
 * Signature of expected method:
 *
 *    public static <T> T findMode(TreeNode<T> root) {...}
 */
public class BstMode {

    static Map<Integer, Integer> map = new HashMap<>();

    public static <T> Integer findMode(TreeNode root) throws Exception {
        if(root == null){
            return findMaximum().getKey();
        }

        if(map.containsKey(root.getValue())){
            map.put(root.getValue(), map.get(root.getValue()) + 1 );
        }else{
            map.put(root.getValue(), 1);
        }
        findMode(root.getLeft());
        findMode(root.getRight());

        return findMaximum().getKey();
    }

    private static Map.Entry<Integer, Integer> findMaximum() throws Exception {
        if (map.size() == 0){
            throw new Exception("No elements in Binary Tree");
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
}