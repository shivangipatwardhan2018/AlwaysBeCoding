package BinaryTrees;


import model.TreeNode;

/**
 * Check if a binary tree is a binary search tree. To keep things simple, assume
 * that the binary tree contains only integers.
 *
 * Signature of expected method:
 *
 *    public static boolean isBst(TreeNode<Integer> rootNode) {...}
 */

public class BstIsBst {

    public static boolean isBst(TreeNode root) {

        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);



    }

    private static boolean isBst(TreeNode rootNode, int minValue, int maxValue) {
        if (rootNode == null) {
            return true;
        }

        boolean check = minValue <= rootNode.getValue() && rootNode.getValue() < maxValue;
        if(check)
            return isBst(rootNode.getLeft(), minValue, rootNode.getValue())
            && isBst(rootNode.getRight(), rootNode.getValue() + 1,
                        maxValue);
        return false;
    }
}
