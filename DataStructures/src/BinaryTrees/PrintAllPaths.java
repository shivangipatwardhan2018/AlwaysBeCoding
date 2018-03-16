package BinaryTrees;

import model.TreeNode;

import java.util.LinkedList;

/**
 * Given the root of a binary tree, print all different paths from root to
 * leaves to standard out.
 *
 * Signature of expected method:
 *
 *    public static void printPaths(TreeNode<?> root) {...}
 */
public class PrintAllPaths {
    public static void printPaths(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        printPaths(root, list);
    }

    private static void printPaths(TreeNode root, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        int value = root.getValue();
        path.add(value);
        printPaths(root.getLeft(), path);
        printPaths(root.getRight(), path);

        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println(path);
        }

        path.removeLast();
    }
}