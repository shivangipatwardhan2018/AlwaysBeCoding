package BinaryTrees;

import model.TreeNode;

public class BstLookUp {

    /**
     * Check if a given node exists in the binary search tree.
     *
     * Signature of expected method:
     *
     *    public static <T> boolean lookup(TreeNode<T> rootNode,
     TreeNode<T> searchedNode, Comparator<T> comparator) {...}
     */

    public static <T> boolean lookup(TreeNode rootNode, TreeNode searchedNode) {

        if(rootNode == null){
            return false;
        }

        if(rootNode.getValue() == searchedNode.getValue()){
            return true;
        }

        if(rootNode.getValue() > searchedNode.getValue()){
            lookup(rootNode.getLeft(), searchedNode);
        }else{
            lookup(rootNode.getRight(), searchedNode);
        }

        return false;
    }
}
