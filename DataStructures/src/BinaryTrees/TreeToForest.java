//package BinaryTrees;
//
//import model.TreeNode;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.concurrent.SynchronousQueue;
//
///**
// * Convert a tree to forest of even nodes
// */
//public class TreeToForest {
//
//
//    public ArrayList<TreeNode> treeToForest(TreeNode root){
//
//        if(root == null){
//            return null;
//        }
//        ArrayList<TreeNode> soln = new ArrayList<>();
//
//        if(!isErase(root)){
//            treeToForest(root.getLeft());
//            treeToForest(root.getRight());
//        }else{
//            soln.add(treeToForestHelper(root.getLeft()));
//            soln.add(treeToForestHelper(root.getRight()));
//        }
//        return soln;
//    }
//
//    private TreeNode treeToForestHelper(TreeNode root) {
//        if(root != null){
//            return null;
//        }
//
//        //remove element add to forest
//
//    }
//
//    private boolean isErase(TreeNode root) {
//
//        ArrayList<Integer> eraseElements = new ArrayList<>();
//        eraseElements.add(2);
//        eraseElements.add(3);
//        return eraseElements.contains(root.getValue());
//    }
//
//}
