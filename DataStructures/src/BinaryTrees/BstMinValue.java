package BinaryTrees;

import model.TreeNode;

/**
 * Find the smallest value in a binary search tree.
 *
 * Signature of expected method:
 *
 *    public static <T> T minValue(TreeNode<T> root) {...}
 */

public class BstMinValue {

    public static <T> int minValue(TreeNode root) throws Exception {

        if(root == null){
            throw new Exception("Invalid input");
        }

        while (root.getLeft() != null) {
            root = root.getLeft();
        }

        return root.getValue();
    }


}
