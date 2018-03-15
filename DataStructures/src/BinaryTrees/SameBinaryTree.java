package BinaryTrees;

import model.TreeNode;

/**
 * Determine if two binary trees are structurally identical.
 *
 * Signature of expected method:
 *
 *    public static <T> boolean isSameTree(TreeNode<T> rootFoo,
 TreeNode<T> rootBar,
 Comparator<T> comparator) {...}
 */

public class SameBinaryTree {

    public static <T> boolean isSameTree(TreeNode rootOne, TreeNode rootTwo){

        if(rootOne == null && rootTwo == null){
            return true;
        }

        if(rootOne != null || rootTwo != null){
            return rootOne.getValue() == rootTwo.getValue() &&
                    isSameTree(rootOne.getLeft(), rootTwo.getLeft()) &&
                    isSameTree(rootOne.getRight(), rootTwo.getRight());
        }

        return false;

    }


}
