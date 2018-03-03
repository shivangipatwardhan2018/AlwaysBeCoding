package Iterators;

import model.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Preorder Iterator for Binary Trees
 */
public class PreOrderIterator implements Iterator<Integer>{

    private Integer nextNodeValue;
    private final Stack<TreeNode> preOrderNodeQueue;

    public PreOrderIterator(TreeNode root){
        preOrderNodeQueue = new Stack<>();
        preOrderNodeQueue.push(root);
        nextNodeValue = null;
    }


    @Override
    public boolean hasNext() {
        if(nextNodeValue != null){
            return true;
        }

        if(preOrderNodeQueue.empty()){
            return false;
        }

        TreeNode node = preOrderNodeQueue.peek();
        nextNodeValue = node.getValue();
        if(node.getLeft() != null){
            preOrderNodeQueue.push(node.getLeft());
        }else{
            while (!preOrderNodeQueue.empty()) {
                TreeNode current = preOrderNodeQueue.pop();
                if (current.getRight() != null) {
                    preOrderNodeQueue.push(current.getRight());
                    break;
                }
            }
        }

        return true;
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException("No Such element");
        }
        Integer toReturn = nextNodeValue;
        nextNodeValue = null;
        return toReturn;
    }
}
