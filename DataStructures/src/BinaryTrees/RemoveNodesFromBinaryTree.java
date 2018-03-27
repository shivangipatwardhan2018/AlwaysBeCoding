package BinaryTrees;

import model.TreeNode;

public class RemoveNodesFromBinaryTree {

    class Solution {

        public TreeNode deleteNode(TreeNode root, int key) {

            if(root==null) return root;

//          if the value of the node value at root is less than the key
//          then the algorithm has explore the right side of the root and set the right to the
//          new value to be computed (call delete node again)
            if(key>root.getValue()){
                root.setRight(deleteNode(root.getRight(),key));
            }
//          if the value of the root node is less than the key, then the left side of the tree has
//          to be explored, so the left sub-tree will the solution of deleting something on the left side of the tree
            else if(key<root.getValue()){
                root.setLeft(deleteNode(root.getLeft(),key));
            }
            //Else if the current node being explored is the one to be deleted. we need to update the value
//            of the current node with the minimum value of the right side
            else if(root.getLeft()!=null && root.getRight()!=null){
                //the minimum value will be on the left part of the right side, so find that
                root.setValue(findMin(root.getRight()).getValue());
                // recreate the right side of the tree
                root.setRight(deleteNode(root.getRight(),root.getValue()));
            }
            else{
                root=(root.getLeft()!=null)?root.getLeft():root.getRight();
            }
            return root;
        }

        public TreeNode findMin(TreeNode root){
            if(root==null) return null;
            else if(root.getLeft()==null){
                return root;
            }
            return findMin(root.getLeft());
        }

    }


}
