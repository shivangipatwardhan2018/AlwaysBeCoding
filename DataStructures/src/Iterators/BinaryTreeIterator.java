package Iterators;


import model.TreeNode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BinaryTreeIterator implements Iterator<Integer>{

    private Deque<TreeNode> stack;

    public BinaryTreeIterator(TreeNode root) {
        stack = new LinkedList<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            stack.offerFirst(node);
            node = node.getLeft();
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        TreeNode top = stack.pop();
        pushLeft(top.getRight());
        return top.getValue();
    }
}
