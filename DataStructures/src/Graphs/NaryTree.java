package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NaryTree {

    public class TreeNode{
        int value;
        ArrayList<TreeNode> children;

        public TreeNode(int input){
            value = input;
            children = new ArrayList<>();
        }


        public void insertChildren(TreeNode child) {
            this.children.add(child);
        }

        public void insertAllChildren(ArrayList<TreeNode> children){
            this.children.addAll(children);
        }
    }

    public void levelOrderTraversal(TreeNode input){
        Queue<TreeNode> queue = new PriorityQueue<>();
       bfs(input, queue);

    }

    public void bfs(TreeNode input, Queue children){

        if(input == null){
            return;
        }

        while(!children.isEmpty()){
            for(int i = 0; i < input.children.size(); i++){
                System.out.print(input.children.get(i).value);
                if(!input.children.get(i).children.isEmpty()){
                    children.add(input.children.get(i).children);
                }

            }
        }

    }


    public static void main(String [] args){

    }



}
