package BinaryTrees;

import model.TreeNode;

/**
 * Find the size of a binary tree.
 *
 * Signature of expected method:
 *
 *    public static int size(TreeNode<?> root) {...}
 */

public class BinarySize {

    public static int size(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + size(root.getLeft()) + size(root.getRight());

    }

}
