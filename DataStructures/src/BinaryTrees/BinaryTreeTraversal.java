package BinaryTrees;

import model.TreeNode;

/**
 * Given the root of a binary tree recursively print the (in/pre/post)-order
 * traversals to standard out.
 *
 * Signature of expected methods:
 *
 *    public static <T> void inorderTraversal(TreeNode<T> root) {...}
 *    public static <T> void preorderTraversal(TreeNode<T> root) {...}
 *    public static <T> void postorderTraversal(TreeNode<T> root) {...}
 */

public class BinaryTreeTraversal {


    public static void inorderTraversal(TreeNode root) {

        if(root != null){
            inorderTraversal(root.getLeft());
            System.out.print(root.getValue());
            inorderTraversal(root.getRight());
        }

    }
    public static void preorderTraversal(TreeNode root) {
        if(root != null){
            System.out.print(root.getValue());
            inorderTraversal(root.getLeft());
            inorderTraversal(root.getRight());
        }

    }
    public static void postorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.getLeft());
            inorderTraversal(root.getRight());
            System.out.print(root.getValue());
        }
    }
}
