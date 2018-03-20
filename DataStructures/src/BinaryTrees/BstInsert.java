package BinaryTrees;


import model.TreeNode;

/**
 * Insert a value into a binary search tree.
 *
 * Signature of expected method:
 *
 *    public static <T> void insert(TreeNode<T> root, T value,
 Comparator<T> comparator) {...}
 *
 */

public class BstInsert {
    public static <T> void insert(TreeNode root, Integer value) {
        if (root == null || value == null){
            return;
        }

        doInsert(root, value);
    }

    private static TreeNode doInsert(TreeNode root, Integer value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (root.getValue() <= value) {
            root.setLeft(doInsert(root.getLeft(), value));
        }

        root.setRight(doInsert(root.getRight(), value));
        return root;
    }


}
