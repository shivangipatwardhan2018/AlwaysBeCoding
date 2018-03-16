package BinaryTrees;

import model.TreeNode;


public class TreeMirror {

    public static <T> void mirror(TreeNode root) {

        if(root == null){
            return;
        }

        mirror(root.getLeft());
        mirror(root.getRight());

        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

    }

}
