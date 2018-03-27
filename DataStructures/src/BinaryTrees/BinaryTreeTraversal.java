package BinaryTrees;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    public void levelOrderTraversal(TreeNode root, List<List<Integer>> input, int height){

        if(root != null){
            return;
        }

        List<Integer> current;
        if(height >= input.size()){
            current = new ArrayList<>();
            current.add(root.getValue());
            input.add(current);
        }else{
            current = input.get(height);
            current.add(root.getValue());
        }
        levelOrderTraversal(root.getLeft(), input, height + 1);
        levelOrderTraversal(root.getRight(), input, height + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> soln = new ArrayList<List<Integer>>();
        if(root == null){
            return null;
        }
        levelOrderTraversal(root, soln, 0);
        return soln;
    }


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
