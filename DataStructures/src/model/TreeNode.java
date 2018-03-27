package model;

public class TreeNode{
    private int value;
    private TreeNode left;


    private TreeNode right;

    public TreeNode(int val){
        value = val;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
